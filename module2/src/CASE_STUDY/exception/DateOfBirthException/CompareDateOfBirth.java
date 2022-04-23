package CASE_STUDY.exception.DateOfBirthException;

public class CompareDateOfBirth{
    private int day;
    private int month;
    private int year;
    private int currentYear;


    public CompareDateOfBirth(int day, int month, int year, int currentYear) throws YearException, DayMonthException {
        this.day = day;
        this.month = month;
        this.year = year;
        this.currentYear = currentYear;
        int age=this.currentYear-this.year;
        if (age<18){
            throw new YearException("Chưa đủ 18 tuổi. Không thể thêm nhân viên vào được. Trở lại màn hình Nhân viên");
        }
        if (day>31||day<0){
            throw new DayMonthException("Bạn nhập sai ngày rồi! Vui lòng nhập lại");
        }
        if(month<0||month>12){
            throw new DayMonthException("Bạn nhập sai tháng rồi. Nhập lại đi");
        }
    }
}
