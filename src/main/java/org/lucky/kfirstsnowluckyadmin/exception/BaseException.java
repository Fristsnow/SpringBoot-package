package org.lucky.kfirstsnowluckyadmin.exception;

//import com.neu.common.utils.MessageUtils;
//import com.neu.common.utils.StringUtils;

/**
 * 基础异常
 *
 * @author neusoft
 */
public class BaseException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 所属模块
     */
//    private String module;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误码对应的参数
     */
    private Object[] args;

    /**
     * 错误消息
     */
    private String defaultMessage;

    public BaseException(Integer code, Object[] args, String defaultMessage)
    {
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

//    public BaseException(String module, String code, Object[] args)
//    {
//        this(module, code, args, null);
//    }

//    public BaseException(String module, String defaultMessage)
//    {
//        this(module, null, null, defaultMessage);
//    }

    public BaseException(Integer code, Object[] args)
    {
        this(code, args, null);
    }

    public BaseException(Integer code, String defaultMessage)
    {
        this(code, null, defaultMessage);
    }


    public BaseException(String defaultMessage)
    {
        this(null, null, defaultMessage);
    }

    public Integer getCode()
    {
        return code;
    }

    public Object[] getArgs()
    {
        return args;
    }

    public String getDefaultMessage()
    {
        return defaultMessage;
    }
}
