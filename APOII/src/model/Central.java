import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Central {
    // ---------------------------------------
    // ATTRIBUTES
    //----------------------------------------

    private Pacient first;
    private int pacients;
    private ArrayList<String> hospitals;

    public Central(Pacient first, int pacients, ArrayList<String> hospitals) {
        this.first = first;
        this.pacients = pacients;
        this.hospitals = hospitals;
    }

    // locate a pacient form the list using his/her code
    public Pacient locate(int code) {
        // point to the first element.
        Pacient current = first;
        // while current is not null and we haven't encountered the code yet.
        while (current != null && current.getCode() != code) {
            // next pacient in the list
            current = current.getNext();
        }
        // if we found a pacient with the code, return the pacient. if not returns null.
        return current;
    }

    // get the last pacient from the list
    public Pacient getLast() {
        // point to the first element.
        Pacient current = first;

        // if the structure is empty, returns null
        if (current != null) {
            // iterate while haven't reached last element.
            while (current.getNext() != null) {
                current = current.getNext();
            }
        }
        return current;
    }

    // get the pacient prior to the indicated one by his/her code
    public Pacient getPrior(int code) {
        // prior goes one position behind current
        Pacient prior = null;
        Pacient current = first;

        // when the reference "current" gets to the indicated pacient by the code,
        // then the reference "prior" will have the answer of the method.
        while (current != null && current.getCode() != code) {
            // prior moves on to the position of current, while current
            // moves to the next pacient in the list.
            prior = current;
            current = current.getNext();
        }
        return current != null ? prior : null;
    }

    // get the number of pacients
    // this method could be obviated by
    // having a variable length at the body of the
    // structure that adds to itself when a new patient is added.
    private int getLength() {

        Pacient current = first;
        int length = 0;

        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    // method for removing a patient from the list.
    public String deletePatient(int code) {
        String result;
        // if the list is empty, throw an exception
        if (first == null) {
            throw new NoSuchElementException("list is empty");
        }
        // if the code of the patient that I want to remove is the first in the list,
        // then I tell the list to point to the next item.
        else if (code == first.getCode()) {
            result = first.getName();
            first = first.getNext();
            pacients--;
            return result;
        } else {
            Pacient prior = getPrior(code);
            if (prior == null) {
                throw new NoSuchElementException("patient " + code + "does not exists");
            }
            // I do the hop, deleting or leaving the patient of the code given to the java garbage collector.
            result = prior.getNext().getName();
            prior.disconnectNext();
            pacients--;
            return result;
        }
    }

    // insert a new patient at the beginning of the list.
    public void addPatientAtBeginning(Pacient pacient) {
        if (first == null) {
            first = pacient;
        } else {
            // point to the one that had been the first
            pacient.changeNext(first);
            // tell the structure a new first has come.
            first = pacient;
        }
        pacients++;
    }

    // insert a new patient at the end of the list.
    public void addPatientAtEnd(Pacient pacient) {
        if (first == null) {
            first = pacient;
        } else {
            Pacient helper = getLast();
            helper.insertAfter(pacient);
        }
        pacients++;
    }

    // insert patient after an indicated patient.
    public void addAfter(int code, Pacient pacient) {
        // of course, the patient that is being indicated is the one
        // that will be the prior to the new patient.
        Pacient prior = locate(code);

        if (prior == null) {
            throw new NoSuchElementException("patient" + code + "does not exists");
        } else {
            prior.insertAfter(pacient);
            pacients++;
        }
    }

    // insert a patient before the stated patient (by his/her code)
    public void addPatientBefore(int code, Pacient pacient) {

        // list is empty?
        if (first == null) {
            throw new NoSuchElementException("patient" + code + "does not exists");
        }// if the code corresponds to the first element, then I tell the new object to point to
        // the first element and assign the new object as first.
        else if (code == first.getCode()) {
            pacient.changeNext(first);
            first = pacient;
            pacients++;
        }// if it is an object different from the first one, then I
        // look for the element prior to the indicated, and, if it is not null,
        //
        else {
            Pacient prior = getPrior(code);
            if (prior == null) {
                throw new NoSuchElementException("patient" + code + "does not exists");
            } else {
                prior.insertAfter(pacient);
                pacients++;
            }

        }
    }

    public static void main(String[] args) {
        // arrayList de hospitales
        ArrayList<String> hosp = new ArrayList<>();
        hosp.add("clinica reina sofia");
        hosp.add("clinica nuestra senora de los remedios");
        hosp.add("clinica de occidente");
        hosp.add("Hospital universitario del valle");
        hosp.add("imbanaco");
        hosp.add("fundacion valle del lili");
        System.out.println(hosp);

        // patients creation
        Pacient pacient11 = new Pacient(8, "Vania", hosp.get(4), "magnesium", 2, null);
        Pacient pacient10 = new Pacient(7, "Nelson", hosp.get(3), "", 1, pacient11);
        Pacient pacient9 = new Pacient(6, "Rosario", hosp.get(2), "", 2, pacient10);
        Pacient pacient8 = new Pacient(5, "Ramon", hosp.get(1), "hello world", 1, pacient9);
        Pacient pacient7 = new Pacient(4, "Natalia", hosp.get(0), "awesome discounts", 2, pacient8);
        Pacient pacient6 = new Pacient(3, "Roberto", hosp.get(5), "beautiful day", 1, pacient7);
        Pacient pacient5 = new Pacient(2, "carlos", hosp.get(4), "smart", 1, pacient6);
        Pacient pacient4 = new Pacient(1, "or", hosp.get(3), "smart", 1, pacient5);
        Pacient pacient3 = new Pacient(789, "maria", hosp.get(2), "smart girl", 2, pacient4);
        Pacient pacient2 = new Pacient(456, "perenzejo", hosp.get(1), "smart bouy", 1, pacient3);
        Pacient pacient1 = new Pacient(123, "pepito", hosp.get(0), "smart bouy", 1, pacient2);


        // class central
        Central central = new Central(pacient1, 11, hosp);
        // trials
        System.out.println(central.getLength());

        System.out.println(central.getLast().getName());

        System.out.println(central.getPrior(7).getName());

        System.out.println(central.locate(7).getName());

        System.out.println("Name of the deleted patient: " + central.deletePatient(123));


    }
}






















