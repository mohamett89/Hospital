package hospital;

class Patient {
    String name;
    double consultationCost;

    public Patient(String name, double consultationCost) {
        this.name = name;
        this.consultationCost = consultationCost;
    }

    public void showDetails() {
        System.out.println("Patient Name: " + name);
        System.out.println("Consultation Fee: $" + consultationCost);
    }
}

class InPatient extends Patient {
    double roomChargePerDay;
    int numberOfDays;

    public InPatient(String name, double consultationCost,
                     double roomChargePerDay, int numberOfDays) {
        super(name, consultationCost);
        this.roomChargePerDay = roomChargePerDay;
        this.numberOfDays = numberOfDays;
    }

    public double calculateBill() {
        return consultationCost + (roomChargePerDay * numberOfDays);
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Daily Room Charge: $" + roomChargePerDay);
        System.out.println("Days Stayed: " + numberOfDays);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

class OutPatient extends Patient {
    double labCost;

    public OutPatient(String name, double consultationCost,
                      double labCost) {
        super(name, consultationCost);
        this.labCost = labCost;
    }

    public double calculateBill() {
        return consultationCost + labCost;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Laboratory Fee: $" + labCost);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

public class hospital {
    public static void main(String[] args) {
        InPatient admittedPatient =
                new InPatient("mohamed", 70, 40, 1);

        OutPatient visitingPatient =
                new OutPatient("mohamed", 70, 25);

        System.out.println("IN-PATIENT DISPLAY");
        admittedPatient.showDetails();

        System.out.println("\nOUT-PATIENT DISPLAY");
        visitingPatient.showDetails();
    }
}
