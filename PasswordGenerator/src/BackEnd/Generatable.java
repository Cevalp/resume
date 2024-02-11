package BackEnd;

import java.util.Random;

public interface Generatable {
    Random rand = new Random();
    String passwordGenerate();
}
