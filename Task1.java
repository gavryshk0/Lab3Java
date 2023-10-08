import java.util.ArrayList;



public class Main {

    public static class Patient {

        private int id;

        private String lastName;

        private String firstName;

        private String middleName;

        private String address;

        private String phone;

        private int medicalCardNumber;

        private String diagnosis;



        public Patient(int id, String lastName, String firstName, String middleName, String address, String phone, int medicalCardNumber, String diagnosis) {

            this.id = id;

            this.lastName = lastName;

            this.firstName = firstName;

            this.middleName = middleName;

            this.address = address;

            this.phone = phone;

            this.medicalCardNumber = medicalCardNumber;

            this.diagnosis = diagnosis;

        }



        public int getId() {

            return id;

        }



        public void setId(int id) {

            this.id = id;

        }



        public String getLastName() {

            return lastName;

        }



        public void setLastName(String lastName) {

            this.lastName = lastName;

        }



        public String getFirstName() {

            return firstName;

        }



        public void setFirstName(String firstName) {

            this.firstName = firstName;

        }



        public String getMiddleName() {

            return middleName;

        }



        public void setMiddleName(String middleName) {

            this.middleName = middleName;

        }



        public String getAddress() {

            return address;

        }



        public void setAddress(String address) {

            this.address = address;

        }



        public String getPhone() {

            return phone;

        }



        public void setPhone(String phone) {

            this.phone = phone;

        }



        public int getMedicalCardNumber() {

            return medicalCardNumber;

        }



        public void setMedicalCardNumber(int medicalCardNumber) {

            this.medicalCardNumber = medicalCardNumber;

        }



        public String getDiagnosis() {

            return diagnosis;

        }



        public void setDiagnosis(String diagnosis) {

            this.diagnosis = diagnosis;

        }



        @Override

        public String toString() {

            return "Patient{" +

                    "id=" + id +

                    ", lastName='" + lastName + '\'' +

                    ", firstName='" + firstName + '\'' +

                    ", middleName='" + middleName + '\'' +

                    ", address='" + address + '\'' +

                    ", phone='" + phone + '\'' +

                    ", medicalCardNumber=" + medicalCardNumber +

                    ", diagnosis='" + diagnosis + '\'' +

                    '}';

        }



        public static ArrayList<Patient> createPatients() {

            ArrayList<Patient> patients = new ArrayList<>();

            patients.add(new Patient(1, "Smith", "John", "A.", "123 Main St", "555-1234", 1001, "Flu"));

            patients.add(new Patient(2, "Johnson", "Mary", "B.", "456 Elm St", "555-5678", 1002, "Fever"));

            patients.add(new Patient(3, "Brown", "David", "C.", "789 Oak St", "555-9876", 1003, "Headache"));

            patients.add(new Patient(4, "Wilson", "Alice", "D.", "101 Pine St", "555-4321", 1004, "Flu"));

            patients.add(new Patient(5, "Lee", "Robert", "E.", "202 Cedar St", "555-8765", 1005, "Fever"));

            return patients;

        }



        public static ArrayList<Patient> findPatientsWithDiagnosis(ArrayList<Patient> patients, String targetDiagnosis) {

            ArrayList<Patient> result = new ArrayList<>();

            for (Patient patient : patients) {

                if (patient.getDiagnosis().equalsIgnoreCase(targetDiagnosis)) {

                    result.add(patient);

                }

            }

            return result;

        }



        public static ArrayList<Patient> findPatientsInMedicalCardRange(ArrayList<Patient> patients, int min, int max) {

            ArrayList<Patient> result = new ArrayList<>();

            for (Patient patient : patients) {

                if (patient.getMedicalCardNumber() >= min && patient.getMedicalCardNumber() <= max) {

                    result.add(patient);

                }

            }

            return result;

        }

    }



    public static void main(String[] args) {

        ArrayList<Patient> patients = Patient.createPatients();



        String targetDiagnosis = "Flu";

        ArrayList<Patient> patientsWithDiagnosis = Patient.findPatientsWithDiagnosis(patients, targetDiagnosis);

        System.out.println("Пацієнти з діагнозом '" + targetDiagnosis + "':");

        for (Patient patient : patientsWithDiagnosis) {

            System.out.println(patient);

        }



        int minMedicalCardNumber = 1002;

        int maxMedicalCardNumber = 1004;

        ArrayList<Patient> patientsInMedicalCardRange = Patient.findPatientsInMedicalCardRange(patients, minMedicalCardNumber, maxMedicalCardNumber);

        System.out.println("Пацієнти з номерами медичних карт в інтервалі " + minMedicalCardNumber + " - " + maxMedicalCardNumber + ":");

        for (Patient patient : patientsInMedicalCardRange) {

            System.out.println(patient);

        }

    }

}

