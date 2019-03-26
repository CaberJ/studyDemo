package cn.caber.ssmDemo.pojo;

public class Result {
    private boolean flag;
    private String massage;

    public Result() {
    }


    public Result(boolean flag, String massage) {
        this.flag = flag;
        this.massage = massage;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}

