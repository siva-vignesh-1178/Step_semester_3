class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }

        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerCodePractice {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        System.out.println(
            l.changeCode("1234", "5678")
                ? "Code changed successfully"
                : "Code change rejected"
        );

        System.out.println(
            l.changeCode("0000", "9999")
                ? "Code changed successfully"
                : "Code change rejected"
        );

        System.out.println("Locker number: " + l.getLockerNumber());
    }
}