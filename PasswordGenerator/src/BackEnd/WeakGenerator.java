package BackEnd;


public class WeakGenerator implements Generatable {
    @Override
    public String passwordGenerate() {
        StringBuilder password = new StringBuilder();
        for (int i=0; i<5; i++){
           char c = (char)(Generatable.rand.nextInt(26) + 'a');
           password.append(c);
        }
        return password.toString();
    }
}
