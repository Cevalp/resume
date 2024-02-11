package BackEnd;

public class IntermediateGenerator implements Generatable{
    @Override
    public String passwordGenerate() {
        StringBuilder password = new StringBuilder();
        for (int i=0; i<10; i++){
            char c;
            int choice = Generatable.rand.nextInt(3);
            if (choice == 0){
                // if is 0, than generate random lowercase letter
                c = (char)(Generatable.rand.nextInt(26) + 'a');
            } else if (choice == 1){
                //if is 1 than generate random uppercase letter
                c = (char)(Generatable.rand.nextInt(26) + 'A');
            } else {
                // if is 2, generate random number 0-9
                c = (char)(Generatable.rand.nextInt(10) + '0');
            }
            password.append(c);
        }
        return password.toString();
    }
}
