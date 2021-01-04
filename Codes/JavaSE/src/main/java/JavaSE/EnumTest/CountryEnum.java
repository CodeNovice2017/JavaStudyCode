package JavaSE.EnumTest;

public enum CountryEnum {
    
    ONE(1,"齐"),TWO(2,"周");

    private Integer returnCode;
    private String returnMessage;

    private CountryEnum(int returnCode,String returnMessage){
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }
    public static CountryEnum countryEnum_forEach(int index){
        CountryEnum[] arr = CountryEnum.values();
        for (CountryEnum countryEnum : arr) {
            if(countryEnum.returnCode == index){
                return countryEnum;
            }
        }
        return null;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
}
