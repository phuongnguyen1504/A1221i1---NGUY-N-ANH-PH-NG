package ss16_io_text_file.utils.compare;

import ss16_io_text_file.model.Student;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
       return o1.getNameStudent().compareTo(o2.getNameStudent());
    }
}
