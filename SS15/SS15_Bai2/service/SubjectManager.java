package SS15_Bai2.service;

import SS15_Bai2.model.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SubjectManager<T extends Subject> {
    private final List<T> subjectList = new ArrayList<>();

    public void addSubject(T subject) {
        subjectList.add(subject);
        System.out.println("Thêm môn học thành công!");
    }

    public boolean deleteSubject(String code) {
        return subjectList.removeIf(subject -> subject.getCode().equalsIgnoreCase(code));
    }

    public void displayAll() {
        if (subjectList.isEmpty()) {
            System.out.println("Danh sách môn học trống.");
            return;
        }
        subjectList.forEach(System.out::println);
    }

    public void searchByName(String name) {
        Optional<T> result = subjectList.stream()
                .filter(subject -> subject.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Không có môn học phù hợp");
        }
    }

    public void filterHighCredits() {
        long count = subjectList.stream()
                .filter(subject -> subject.getCredits() > 3)
                .peek(System.out::println)
                .count();

        if (count == 0) {
            System.out.println("Không có môn học nào có số tín chỉ > 3");
        }
    }
}