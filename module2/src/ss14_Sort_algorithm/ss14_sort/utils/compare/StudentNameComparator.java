package ss14_sort.utils.compare;

import ss14_sort.model.Student;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
       return o1.getNameStudent().compareTo(o2.getNameStudent());
    }
}
