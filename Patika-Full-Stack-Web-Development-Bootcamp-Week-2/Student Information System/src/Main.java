public class Main {
    public static void main(String[] args) {

        Course math = new Course("Mathematics", "MAT101", "MAT", 0.30);
        Course physics = new Course("Physics", "FZK101", "FZK", 0.40);
        Course chemistry = new Course("Chemistry", "KMY101", "KMY", 0.20);

        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MAT");
        Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "FZK");
        Teacher t3 = new Teacher("Ali Veli", "90550000002", "KMY");

        math.addTeacher(t1);
        physics.addTeacher(t2);
        chemistry.addTeacher(t3);

        Student s1 = new Student("İnek Şaban", 4, "140144015", math, physics, chemistry);
        s1.addBulkExamNote(50, 20, 40);
        s1.addBulkWrittenNote(80, 30, 60);  // Sözlü notları ekleniyor
        s1.isPass();

        Student s2 = new Student("Güdük Necmi", 4, "2211133", math, physics, chemistry);
        s2.addBulkExamNote(100, 50, 40);
        s2.addBulkWrittenNote(90, 40, 70);  // Sözlü notları ekleniyor
        s2.isPass();

        Student s3 = new Student("Hayta İsmail", 4, "221121312", math, physics, chemistry);
        s3.addBulkExamNote(50, 20, 40);
        s3.addBulkWrittenNote(75, 35, 55);  // Sözlü notları ekleniyor
        s3.isPass();
    }
}
