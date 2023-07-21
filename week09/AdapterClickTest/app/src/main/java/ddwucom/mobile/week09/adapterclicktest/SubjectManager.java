package ddwucom.mobile.week09.adapterclicktest;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("망고");
        subjectList.add("파파야");
        subjectList.add("바나나");
        subjectList.add("리치");
        subjectList.add("두리안");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

//    추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

//    삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }

//    수정
    public void updateData(int idx, String data) {
        subjectList.set(idx, data);
    }

    public String getSubjectByPos(int pos){
        return subjectList.get(pos);
    }
}

