public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int writtenNote; // Sözlü notu
    int note; // Sınav notu
    double oralWeight; // Sözlü notun ortalamaya etki yüzdesi

    public Course(String name, String code, String prefix, double oralWeight) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.note = 0;
        this.writtenNote = 0;
        this.oralWeight = oralWeight;
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("Operation successful");
        } else {
            System.out.println(t.name + " cannot teach this course.");
        }
    }

    public void setWrittenNote(int writtenNote) {
        if (writtenNote >= 0 && writtenNote <= 100) {
            this.writtenNote = writtenNote;
        }
    }

    public void setNote(int note) {
        if (note >= 0 && note <= 100) {
            this.note = note;
        }
    }

    public double calculateCourseAverage() {
        // Sözlü notun ortalamaya etkisi ile sınav notunun etkisi hesaplanıyor.
        return (this.writtenNote * this.oralWeight) + (this.note * (1 - this.oralWeight));
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println("Instructor for the course " + this.name + ": " + courseTeacher.name);
        } else {
            System.out.println("No instructor assigned to the course " + this.name + ".");
        }
    }
}