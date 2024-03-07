import java.awt.*;

public enum Colors {
    _2(191,191,191),
    _4(102, 102, 102),
    _8(255, 204, 153),
    _16(255, 170, 128),
    _32(246, 124, 96),
    _64(246, 94, 59),
    _128(237, 207, 115),
    _256(237, 204, 98),
    _512(237, 200, 80),
    _1024(237, 197, 63),
    _2048(237, 194, 45);

    private final int r, g, b;

    private Colors(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color getColor(){
        return new Color(r,g,b);
    }

}
