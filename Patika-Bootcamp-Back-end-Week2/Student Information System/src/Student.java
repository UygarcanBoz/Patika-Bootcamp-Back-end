public class Student {
    String name;
    String stuNo;
    int classes;
    Course math;
    Course physics;
    Course chemistry;
    double average;
    boolean isPass;

    public Student(String name, int classes, String stuNo, Course math, Course physics, Course chemistry) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calculateAverage();
        this.isPass = false;
    }

    public void addBulkExamNote(int math, int physics, int chemistry) {
        this.math.setNote(math);
        this.physics.setNote(physics);
        this.chemistry.setNote(chemistry);
    }

    public void addBulkWrittenNote(int math, int physics, int chemistry) {
        this.math.setWrittenNote(math);
        this.physics.setWrittenNote(physics);
        this.chemistry.setWrittenNote(chemistry);
    }

    public void isPass() {
        if (this.math.note == 0 || this.physics.note == 0 || this.chemistry.note == 0) {
            System.out.println("Grades are not fully entered");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Average: " + this.average);
            if (this.isPass) {
                System.out.println("Passed the Class");
            } else {
                System.out.println("Failed the Class");
            }
        }
    }

    private void calculateAverage() {
        this.average = (this.physics.calculateCourseAverage() + this.chemistry.calculateCourseAverage()
                + this.math.calculateCourseAverage()) / 3.0;
    }

    private boolean isCheckPass() {
        calculateAverage();
        return this.average > 55;
    }

    private void printNote() {
        System.out.println("=========================");
        System.out.println("Student: " + this.name);
        System.out.println("Math Grade: " + this.math.note + " (Oral: " + this.math.writtenNote + ")");
        System.out.println("Physics Grade: " + this.physics.note + " (Oral: " + this.physics.writtenNote + ")");
        System.out.println("Chemistry Grade: " + this.chemistry.note + " (Oral: " + this.chemistry.writtenNote + ")");
    }
}
