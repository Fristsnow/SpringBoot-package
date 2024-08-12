package org.lucky.kfirstsnowluckyadmin.utils.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.io.InputStream;

public class AliOssUtils {

    private static AilOssConfig ailOssConfig;

    public AliOssUtils(AilOssConfig ailOssConfig) {
        this.ailOssConfig = ailOssConfig;
    }

    public static String uploadFile(String objectName, InputStream inputStream) {
        OSS ossClient = getOssConfig();
        String url = "";
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(ailOssConfig.getBUCKET_NAME(), objectName, inputStream);
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            url = "https://" + ailOssConfig.getBUCKET_NAME() + "." + ailOssConfig.getENDPOINT().substring(ailOssConfig.getENDPOINT().lastIndexOf("/") + 1) + "/" + objectName;
        } catch (OSSException oe) {
            ossException(oe);
        } catch (ClientException ce) {
            ossClientException(ce);
        } finally {
            ossClientIsNull(ossClient);
        }
        return url;
    }

    public static String deleteFile(String objectName) {
        OSS ossClient = getOssConfig();
        try {
            ossClient.deleteObject(ailOssConfig.getBUCKET_NAME(), objectName);
        } catch (OSSException oe) {
            ossException(oe);
        } catch (ClientException ce) {
            ossClientException(ce);
        } finally {
            ossClientIsNull(ossClient);
        }
        return "delete oss success";
    }

    public static void downloadFile(String objectName, String downloadPath) {
        OSS ossClient = getOssConfig();

        try {
            ossClient.getObject(new GetObjectRequest(ailOssConfig.getBUCKET_NAME(), objectName), new File(downloadPath + objectName));
        } catch (OSSException oe) {
            ossException(oe);
        } catch (ClientException ce) {
            ossClientException(ce);
        } finally {
            ossClientIsNull(ossClient);
        }
    }

    private static OSS getOssConfig() {
        OSS ossClient = new OSSClientBuilder().build(ailOssConfig.getENDPOINT(), ailOssConfig.getACCESS_KEY_ID(), ailOssConfig.getACCESS_KEY_SECRET());
        return ossClient;
    }

    private static void ossClientIsNull(OSS ossClient) {
        if (ossClient != null) {
            ossClient.shutdown();
        }
    }

    private static void ossClientException(ClientException ce) {
        System.out.println("Caught an ClientException, which means the client encountered "
                + "a serious internal problem while trying to communicate with OSS, "
                + "such as not being able to access the network.");
        System.out.println("Error Message:" + ce.getMessage());
    }

    private static void ossException(OSSException oe) {
        System.out.println("Caught an OSSException, which means your request made it to OSS, "
                + "but was rejected with an error response for some reason.");
        System.out.println("Error Message:" + oe.getErrorMessage());
        System.out.println("Error Code:" + oe.getErrorCode());
        System.out.println("Request ID:" + oe.getRequestId());
        System.out.println("Host ID:" + oe.getHostId());
    }

}
