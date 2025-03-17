// Abstract class: Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

// Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

// Subclass: InPatient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String medicalHistory;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicalHistory = "No records yet.";
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        this.medicalHistory = record;
    }

    @Override
    public String viewRecords() {
        return medicalHistory;
    }
}

// Subclass: OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = "No records yet.";
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.medicalHistory = record;
    }

    @Override
    public String viewRecords() {
        return medicalHistory;
    }
}

// Main class to test Hospital Patient Management System
public class HospitalManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("P001", "Rajesh Kumar", 45, 5, 2000);
        OutPatient outPatient = new OutPatient("P002", "Meena Sharma", 30, 500);

        inPatient.getPatientDetails();
        System.out.println("Total Bill: " + inPatient.calculateBill());
        inPatient.addRecord("Diagnosed with fever, prescribed antibiotics.");
        System.out.println("Medical Record: " + inPatient.viewRecords());
        System.out.println();

        outPatient.getPatientDetails();
        System.out.println("Total Bill: " + outPatient.calculateBill());
        outPatient.addRecord("Routine check-up, no issues detected.");
        System.out.println("Medical Record: " + outPatient.viewRecords());
    }
}
