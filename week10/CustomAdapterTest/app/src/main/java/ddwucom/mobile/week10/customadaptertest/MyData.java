package ddwucom.mobile.week10.customadaptertest;

public class MyData {
    private long _id;
    private String name;
    private String phone;

    //매개변수 있는 생성자를 만들어서 디폴트생성자는 없어진다
    // = 이 객체는 무조건 세개 값이 있는 상태로 만들어져야 한다 (필수값!!)
    public MyData(long _id, String name, String phone) {
        //DB의 기본키 값은 _id라는 이름, long타입으로 지정 -> 안드로이드 내부 구조 약속!!
        this._id = _id;
        this.name = name;
        this.phone = phone;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
