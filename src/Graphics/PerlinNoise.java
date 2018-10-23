package Graphics;

import java.util.Random;

public class PerlinNoise {

    // Function to linearly interpolate between a0 and a1
// Weight w should be in the range [0.0, 1.0]
    private double lerp(double a0, double a1, double w) {
        return (1.0 - w)*a0 + w*a1;

        // as an alternative, this slightly faster equivalent formula can be used:
        // return a0 + w*(a1 - a0);
    }

    // Computes the dot product of the distance and gradient vectors.
    private double dotGridGradient(int ix, int iy, double x, double y) {

        // Precomputed (or otherwise) gradient vectors at each grid node

        // Compute the distance vector
        double dx = x - (double)ix;
        double dy = y - (double)iy;

        // Compute the dot-product
        return (dx*Gradient[iy][ix][0] + dy*Gradient[iy][ix][1]);
    }

    // Compute Perlin noise at coordinates x, y
    public double perlin(double x, double y) {

        // Determine grid cell coordinates
        int x0 = (int)(x);
        int x1 = x0 + 1;
        int y0 = (int)(y);
        int y1 = y0 + 1;

        // Determine interpolation weights
        // Could also use higher order polynomial/s-curve here
        double sx = x - (double)x0;
        double sy = y - (double)y0;

        // Interpolate between grid point gradients
        double n0, n1, ix0, ix1, value;
        n0 = dotGridGradient(x0, y0, x, y);
        n1 = dotGridGradient(x1, y0, x, y);
        ix0 = lerp(n0, n1, sx);
        n0 = dotGridGradient(x0, y1, x, y);
        n1 = dotGridGradient(x1, y1, x, y);
        ix1 = lerp(n0, n1, sx);
        value = lerp(ix0, ix1, sy);

        return value;
    }
    private double Gradient[][][];
    public PerlinNoise(int n) {
        Gradient = new double[n][n][2];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Gradient[i][j][0]=r.nextDouble()*2-1;
                double t1 = Gradient[i][j][0];
                double t2 = 1-t1*t1;
                Gradient[i][j][0]=r.nextInt(2)==1?t2:-1*t2;

            }
        }
        /*for (int i = 0; i < p.length; i++) {
            int index = r.nextInt(p.length);
            int tmp = p[index];
            p[index] = p[i];
            p[i] = tmp;
        }
        for (int i = 0; i < 256; i++) {
            p[i] = permutation[i];
            p[256 + i] = p[i];
        }*/
    }
    /*
    static public double noise(double x, double y) {
        int X = (int) Math.floor(x) & 255,                  // FIND UNIT CUBE THAT
                Y = (int) Math.floor(y) & 255;                  // CONTAINS POINT.
        x -= Math.floor(x);                                // FIND RELATIVE X,Y,Z
        y -= Math.floor(y);                                // OF POINT IN CUBE.
        double u = fade(x),                                // COMPUTE FADE CURVES
                v = fade(y);                              // FOR EACH OF X,Y,Z.
        int A = p[X] + Y, AA = p[A], AB = p[A + 1],      // HASH COORDINATES OF
                B = p[X + 1] + Y, BA = p[B], BB = p[B + 1];      // THE 8 CUBE CORNERS,

        return lerp(
            v,
            lerp(
                 u,
                 grad(p[AA], x, y, 0),
                 grad(p[BA], x - 1, y, 0)
            ),
                lerp(
                   u,
                   grad(p[AB], x, y - 1, 0),
                   grad(p[BB], x - 1, y - 1, 0)
            )
        );
    }

    static double fade(double t) {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    static double lerp(double t, double a, double b) {
        return a + t * (b - a);
    }

    static double grad(int hash, double x, double y, double z) {
        int h = hash & 15;                      // CONVERT LO 4 BITS OF HASH CODE
        double u = h < 8 ? x : y,                 // INTO 12 GRADIENT DIRECTIONS.
                v = h < 4 ? y : h == 12 || h == 14 ? x : z;
        return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
    }

    static final int p[] = new int[512], permutation[] = {151, 160, 137, 91, 90, 15,
            131, 13, 201, 95, 96, 53, 194, 233, 7, 225, 140, 36, 103, 30, 69, 142, 8, 99, 37, 240, 21, 10, 23,
            190, 6, 148, 247, 120, 234, 75, 0, 26, 197, 62, 94, 252, 219, 203, 117, 35, 11, 32, 57, 177, 33,
            88, 237, 149, 56, 87, 174, 20, 125, 136, 171, 168, 68, 175, 74, 165, 71, 134, 139, 48, 27, 166,
            77, 146, 158, 231, 83, 111, 229, 122, 60, 211, 133, 230, 220, 105, 92, 41, 55, 46, 245, 40, 244,
            102, 143, 54, 65, 25, 63, 161, 1, 216, 80, 73, 209, 76, 132, 187, 208, 89, 18, 169, 200, 196,
            135, 130, 116, 188, 159, 86, 164, 100, 109, 198, 173, 186, 3, 64, 52, 217, 226, 250, 124, 123,
            5, 202, 38, 147, 118, 126, 255, 82, 85, 212, 207, 206, 59, 227, 47, 16, 58, 17, 182, 189, 28, 42,
            223, 183, 170, 213, 119, 248, 152, 2, 44, 154, 163, 70, 221, 153, 101, 155, 167, 43, 172, 9,
            129, 22, 39, 253, 19, 98, 108, 110, 79, 113, 224, 232, 178, 185, 112, 104, 218, 246, 97, 228,
            251, 34, 242, 193, 238, 210, 144, 12, 191, 179, 162, 241, 81, 51, 145, 235, 249, 14, 239, 107,
            49, 192, 214, 31, 181, 199, 106, 157, 184, 84, 204, 176, 115, 121, 50, 45, 127, 4, 150, 254,
            138, 236, 205, 93, 222, 114, 67, 29, 24, 72, 243, 141, 128, 195, 78, 66, 215, 61, 156, 180
    };*/
}
