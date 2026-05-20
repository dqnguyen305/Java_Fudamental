package SS13_Bai2.business;

import SS13_Bai2.model.Student;
import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements Manage<Student> {
    private final List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student item) {
        studentList.add(item);
    }

    @Override
    public void update(int index, Student item) {
        if (index >= 0 && index < studentList.size()) {
            studentList.set(index, item);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < studentList.size()) {
            studentList.remove(index);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void display() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách điểm danh trống.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public int findIndexById(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id.trim())) {
                return i;
            }
        }
        return -1;
    }
}