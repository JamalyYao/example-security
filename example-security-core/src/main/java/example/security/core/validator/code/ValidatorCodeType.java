package example.security.core.validator.code;

import example.security.core.constants.SecurityBrowserConstant;

public enum ValidatorCodeType {
    /***
     * 短信
     */
    SMS{
        @Override
        public String getParamNameOnValidate() {
            return SecurityBrowserConstant.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /***
     * 图片
     */
    IMAGE{
        @Override
        public String getParamNameOnValidate() {
            return SecurityBrowserConstant.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();
}
