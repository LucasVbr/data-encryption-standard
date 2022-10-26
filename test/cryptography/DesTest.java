/*
 * DesTest.java, 26/10/2022
 * INU Champollion 2022-2023, L3 INFO
 * pas de copyright, aucun droits
 */
package cryptography;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gaël BURGUÈS
 * @author Laurian DUFRECHOU
 * @author Lucàs VABRE
 */
class DesTest {

    @Test
    @DisplayName("stringToBits")
    void stringToBits() {
        HashMap<String, int[]> TESTS = new HashMap<>() {{
            // Empty string
            put("", new int[]{});

            // abc, maj
            put("abcdefghijklmnopqrstuvwxyz", new int[]{
                    0, 1, 1, 0, 0, 0, 0, 1, // a
                    0, 1, 1, 0, 0, 0, 1, 0, // b
                    0, 1, 1, 0, 0, 0, 1, 1, // c
                    0, 1, 1, 0, 0, 1, 0, 0, // d
                    0, 1, 1, 0, 0, 1, 0, 1, // e
                    0, 1, 1, 0, 0, 1, 1, 0, // f
                    0, 1, 1, 0, 0, 1, 1, 1, // g
                    0, 1, 1, 0, 1, 0, 0, 0, // h
                    0, 1, 1, 0, 1, 0, 0, 1, // i
                    0, 1, 1, 0, 1, 0, 1, 0, // j
                    0, 1, 1, 0, 1, 0, 1, 1, // k
                    0, 1, 1, 0, 1, 1, 0, 0, // l
                    0, 1, 1, 0, 1, 1, 0, 1, // m
                    0, 1, 1, 0, 1, 1, 1, 0, // n
                    0, 1, 1, 0, 1, 1, 1, 1, // o
                    0, 1, 1, 1, 0, 0, 0, 0, // p
                    0, 1, 1, 1, 0, 0, 0, 1, // q
                    0, 1, 1, 1, 0, 0, 1, 0, // r
                    0, 1, 1, 1, 0, 0, 1, 1, // s
                    0, 1, 1, 1, 0, 1, 0, 0, // t
                    0, 1, 1, 1, 0, 1, 0, 1, // u
                    0, 1, 1, 1, 0, 1, 1, 0, // v
                    0, 1, 1, 1, 0, 1, 1, 1, // w
                    0, 1, 1, 1, 1, 0, 0, 0, // x
                    0, 1, 1, 1, 1, 0, 0, 1, // y
                    0, 1, 1, 1, 1, 0, 1, 0, // z
            });

            put("ABCDEFGHIJKLMNOPQRSTUVWXYZ", new int[]{
                    0, 1, 0, 0, 0, 0, 0, 1, // A
                    0, 1, 0, 0, 0, 0, 1, 0, // B
                    0, 1, 0, 0, 0, 0, 1, 1, // C
                    0, 1, 0, 0, 0, 1, 0, 0, // D
                    0, 1, 0, 0, 0, 1, 0, 1, // E
                    0, 1, 0, 0, 0, 1, 1, 0, // F
                    0, 1, 0, 0, 0, 1, 1, 1, // G
                    0, 1, 0, 0, 1, 0, 0, 0, // H
                    0, 1, 0, 0, 1, 0, 0, 1, // I
                    0, 1, 0, 0, 1, 0, 1, 0, // J
                    0, 1, 0, 0, 1, 0, 1, 1, // K
                    0, 1, 0, 0, 1, 1, 0, 0, // L
                    0, 1, 0, 0, 1, 1, 0, 1, // M
                    0, 1, 0, 0, 1, 1, 1, 0, // N
                    0, 1, 0, 0, 1, 1, 1, 1, // O
                    0, 1, 0, 1, 0, 0, 0, 0, // P
                    0, 1, 0, 1, 0, 0, 0, 1, // Q
                    0, 1, 0, 1, 0, 0, 1, 0, // R
                    0, 1, 0, 1, 0, 0, 1, 1, // S
                    0, 1, 0, 1, 0, 1, 0, 0, // T
                    0, 1, 0, 1, 0, 1, 0, 1, // U
                    0, 1, 0, 1, 0, 1, 1, 0, // V
                    0, 1, 0, 1, 0, 1, 1, 1, // W
                    0, 1, 0, 1, 1, 0, 0, 0, // X
                    0, 1, 0, 1, 1, 0, 0, 1, // Y
                    0, 1, 0, 1, 1, 0, 1, 0, // Z
            });

            // Numbers
            put("0123456789", new int[]{
                    0, 0, 1, 1, 0, 0, 0, 0, // 0
                    0, 0, 1, 1, 0, 0, 0, 1, // 1
                    0, 0, 1, 1, 0, 0, 1, 0, // 2
                    0, 0, 1, 1, 0, 0, 1, 1, // 3
                    0, 0, 1, 1, 0, 1, 0, 0, // 4
                    0, 0, 1, 1, 0, 1, 0, 1, // 5
                    0, 0, 1, 1, 0, 1, 1, 0, // 6
                    0, 0, 1, 1, 0, 1, 1, 1, // 7
                    0, 0, 1, 1, 1, 0, 0, 0, // 8
                    0, 0, 1, 1, 1, 0, 0, 1, // 9
            });

            // Special chars
            put("+-/*%=", new int[]{
                    0, 0, 1, 0, 1, 0, 1, 1, // +
                    0, 0, 1, 0, 1, 1, 0, 1, // -
                    0, 0, 1, 0, 1, 1, 1, 1, // /
                    0, 0, 1, 0, 1, 0, 1, 0, // *
                    0, 0, 1, 0, 0, 1, 0, 1, // %
                    0, 0, 1, 1, 1, 1, 0, 1, // =
            });

            put("?!.,;:_ ", new int[]{
                    0, 0, 1, 1, 1, 1, 1, 1, // ?
                    0, 0, 1, 0, 0, 0, 0, 1, // !
                    0, 0, 1, 0, 1, 1, 1, 0, // .
                    0, 0, 1, 0, 1, 1, 0, 0, // ,
                    0, 0, 1, 1, 1, 0, 1, 1, // ;
                    0, 0, 1, 1, 1, 0, 1, 0, // :
                    0, 1, 0, 1, 1, 1, 1, 1, // _
                    0, 0, 1, 0, 0, 0, 0, 0, // space
            });

            put("(){}[]", new int[]{
                    0, 0, 1, 0, 1, 0, 0, 0, // (
                    0, 0, 1, 0, 1, 0, 0, 1, // )
                    0, 1, 1, 1, 1, 0, 1, 1, // {
                    0, 1, 1, 1, 1, 1, 0, 1, // }
                    0, 1, 0, 1, 1, 0, 1, 1, // [
                    0, 1, 0, 1, 1, 1, 0, 1, // ]
            });

            put("&@#^\"'`", new int[]{
                    0, 0, 1, 0, 0, 1, 1, 0, // &
                    0, 1, 0, 0, 0, 0, 0, 0, // @
                    0, 0, 1, 0, 0, 0, 1, 1, // #
                    0, 1, 0, 1, 1, 1, 1, 0, // ^
                    0, 0, 1, 0, 0, 0, 1, 0, // "
                    0, 0, 1, 0, 0, 1, 1, 1, // '
                    0, 1, 1, 0, 0, 0, 0, 0, // `
            });

            // Custom test
            put("Bonjour", new int[]{
                    0, 1, 0, 0, 0, 0, 1, 0, // B
                    0, 1, 1, 0, 1, 1, 1, 1, // o
                    0, 1, 1, 0, 1, 1, 1, 0, // n
                    0, 1, 1, 0, 1, 0, 1, 0, // j
                    0, 1, 1, 0, 1, 1, 1, 1, // o
                    0, 1, 1, 1, 0, 1, 0, 1, // u
                    0, 1, 1, 1, 0, 0, 1, 0, // r
            });
        }};

        for (Map.Entry<String, int[]> test : TESTS.entrySet()) {
            assertArrayEquals(test.getValue(), Des.stringToBits(test.getKey()));
            System.out.printf("\"%s\" -> OK\n", test.getKey());
        }
    }

    @Test
    @DisplayName("stringToBits")
    void bitsToString() {
        HashMap<int[], String> TESTS = new HashMap<>() {{
            // Empty string
            put(new int[]{}, "");

            // abc, maj
            put(new int[]{
                    0, 1, 1, 0, 0, 0, 0, 1, // a
                    0, 1, 1, 0, 0, 0, 1, 0, // b
                    0, 1, 1, 0, 0, 0, 1, 1, // c
                    0, 1, 1, 0, 0, 1, 0, 0, // d
                    0, 1, 1, 0, 0, 1, 0, 1, // e
                    0, 1, 1, 0, 0, 1, 1, 0, // f
                    0, 1, 1, 0, 0, 1, 1, 1, // g
                    0, 1, 1, 0, 1, 0, 0, 0, // h
                    0, 1, 1, 0, 1, 0, 0, 1, // i
                    0, 1, 1, 0, 1, 0, 1, 0, // j
                    0, 1, 1, 0, 1, 0, 1, 1, // k
                    0, 1, 1, 0, 1, 1, 0, 0, // l
                    0, 1, 1, 0, 1, 1, 0, 1, // m
                    0, 1, 1, 0, 1, 1, 1, 0, // n
                    0, 1, 1, 0, 1, 1, 1, 1, // o
                    0, 1, 1, 1, 0, 0, 0, 0, // p
                    0, 1, 1, 1, 0, 0, 0, 1, // q
                    0, 1, 1, 1, 0, 0, 1, 0, // r
                    0, 1, 1, 1, 0, 0, 1, 1, // s
                    0, 1, 1, 1, 0, 1, 0, 0, // t
                    0, 1, 1, 1, 0, 1, 0, 1, // u
                    0, 1, 1, 1, 0, 1, 1, 0, // v
                    0, 1, 1, 1, 0, 1, 1, 1, // w
                    0, 1, 1, 1, 1, 0, 0, 0, // x
                    0, 1, 1, 1, 1, 0, 0, 1, // y
                    0, 1, 1, 1, 1, 0, 1, 0, // z
            }, "abcdefghijklmnopqrstuvwxyz");

            put(new int[]{
                    0, 1, 0, 0, 0, 0, 0, 1, // A
                    0, 1, 0, 0, 0, 0, 1, 0, // B
                    0, 1, 0, 0, 0, 0, 1, 1, // C
                    0, 1, 0, 0, 0, 1, 0, 0, // D
                    0, 1, 0, 0, 0, 1, 0, 1, // E
                    0, 1, 0, 0, 0, 1, 1, 0, // F
                    0, 1, 0, 0, 0, 1, 1, 1, // G
                    0, 1, 0, 0, 1, 0, 0, 0, // H
                    0, 1, 0, 0, 1, 0, 0, 1, // I
                    0, 1, 0, 0, 1, 0, 1, 0, // J
                    0, 1, 0, 0, 1, 0, 1, 1, // K
                    0, 1, 0, 0, 1, 1, 0, 0, // L
                    0, 1, 0, 0, 1, 1, 0, 1, // M
                    0, 1, 0, 0, 1, 1, 1, 0, // N
                    0, 1, 0, 0, 1, 1, 1, 1, // O
                    0, 1, 0, 1, 0, 0, 0, 0, // P
                    0, 1, 0, 1, 0, 0, 0, 1, // Q
                    0, 1, 0, 1, 0, 0, 1, 0, // R
                    0, 1, 0, 1, 0, 0, 1, 1, // S
                    0, 1, 0, 1, 0, 1, 0, 0, // T
                    0, 1, 0, 1, 0, 1, 0, 1, // U
                    0, 1, 0, 1, 0, 1, 1, 0, // V
                    0, 1, 0, 1, 0, 1, 1, 1, // W
                    0, 1, 0, 1, 1, 0, 0, 0, // X
                    0, 1, 0, 1, 1, 0, 0, 1, // Y
                    0, 1, 0, 1, 1, 0, 1, 0, // Z
            }, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

            // Numbers
            put(new int[]{
                    0, 0, 1, 1, 0, 0, 0, 0, // 0
                    0, 0, 1, 1, 0, 0, 0, 1, // 1
                    0, 0, 1, 1, 0, 0, 1, 0, // 2
                    0, 0, 1, 1, 0, 0, 1, 1, // 3
                    0, 0, 1, 1, 0, 1, 0, 0, // 4
                    0, 0, 1, 1, 0, 1, 0, 1, // 5
                    0, 0, 1, 1, 0, 1, 1, 0, // 6
                    0, 0, 1, 1, 0, 1, 1, 1, // 7
                    0, 0, 1, 1, 1, 0, 0, 0, // 8
                    0, 0, 1, 1, 1, 0, 0, 1, // 9
            }, "0123456789");

            // Special chars
            put(new int[]{
                    0, 0, 1, 0, 1, 0, 1, 1, // +
                    0, 0, 1, 0, 1, 1, 0, 1, // -
                    0, 0, 1, 0, 1, 1, 1, 1, // /
                    0, 0, 1, 0, 1, 0, 1, 0, // *
                    0, 0, 1, 0, 0, 1, 0, 1, // %
                    0, 0, 1, 1, 1, 1, 0, 1, // =
            }, "+-/*%=");

            put(new int[]{
                    0, 0, 1, 1, 1, 1, 1, 1, // ?
                    0, 0, 1, 0, 0, 0, 0, 1, // !
                    0, 0, 1, 0, 1, 1, 1, 0, // .
                    0, 0, 1, 0, 1, 1, 0, 0, // ,
                    0, 0, 1, 1, 1, 0, 1, 1, // ;
                    0, 0, 1, 1, 1, 0, 1, 0, // :
                    0, 1, 0, 1, 1, 1, 1, 1, // _
                    0, 0, 1, 0, 0, 0, 0, 0, // space
            }, "?!.,;:_ ");

            put(new int[]{
                    0, 0, 1, 0, 1, 0, 0, 0, // (
                    0, 0, 1, 0, 1, 0, 0, 1, // )
                    0, 1, 1, 1, 1, 0, 1, 1, // {
                    0, 1, 1, 1, 1, 1, 0, 1, // }
                    0, 1, 0, 1, 1, 0, 1, 1, // [
                    0, 1, 0, 1, 1, 1, 0, 1, // ]
            }, "(){}[]");

            put(new int[]{
                    0, 0, 1, 0, 0, 1, 1, 0, // &
                    0, 1, 0, 0, 0, 0, 0, 0, // @
                    0, 0, 1, 0, 0, 0, 1, 1, // #
                    0, 1, 0, 1, 1, 1, 1, 0, // ^
                    0, 0, 1, 0, 0, 0, 1, 0, // "
                    0, 0, 1, 0, 0, 1, 1, 1, // '
                    0, 1, 1, 0, 0, 0, 0, 0, // `
            }, "&@#^\"'`");

            // Custom test
            put(new int[]{
                    0, 1, 0, 0, 0, 0, 1, 0, // B
                    0, 1, 1, 0, 1, 1, 1, 1, // o
                    0, 1, 1, 0, 1, 1, 1, 0, // n
                    0, 1, 1, 0, 1, 0, 1, 0, // j
                    0, 1, 1, 0, 1, 1, 1, 1, // o
                    0, 1, 1, 1, 0, 1, 0, 1, // u
                    0, 1, 1, 1, 0, 0, 1, 0, // r
            }, "Bonjour");
        }};

        for (Map.Entry<int[], String> test : TESTS.entrySet()) {
            assertEquals(test.getValue(), Des.bitsToString(test.getKey()));
            System.out.printf("\"%s\" -> OK\n", test.getValue());
        }
    }

    @Test
    @DisplayName("xor")
    void xor() {

        final int[][][] TESTS = {
                {
                        {0, 1, 0, 1}, // Table 1
                        {0, 0, 1, 1}, // Table 2
                        {0, 1, 1, 0}, // Result expected
                },
        };

        for (int[][] test : TESTS) {
            assertArrayEquals(Des.xor(test[0], test[1]), test[2]);
            System.out.printf(
                    "%s XOR %s -> OK\n",
                    Arrays.toString(test[0]),
                    Arrays.toString(test[1])
            );
        }
    }

    @Test
    @DisplayName("decoupage")
    void decoupage() {
        fail(); // TODO
    }

    @Test
    @DisplayName("generePermutation")
    void generePermutation() {
        fail(); // TODO
    }

    @Test
    @DisplayName("permutation")
    void permutation() {
        fail(); // TODO
    }

    @Test
    @DisplayName("invPermutation")
    void invPermutation() {
        fail(); // TODO
    }

    @Test
    @DisplayName("recollageBloc")
    void recollageBloc() {
        fail(); // TODO
    }

    @Test
    @DisplayName("decaleGauche")
    void decaleGauche() {
        fail(); // TODO
    }

    @Test
    @DisplayName("genereCle")
    void genereCle() {
        fail(); // TODO
    }

    @Test
    @DisplayName("fonction_S")
    void fonction_S() {
        fail(); // TODO
    }

    @Test
    @DisplayName("fonction_F")
    void fonction_F() {
        fail(); // TODO
    }

    @Test
    @DisplayName("crypte")
    void crypte() {
        fail(); // TODO
    }

    @Test
    @DisplayName("decrypte")
    void decrypte() {
        fail(); // TODO
    }
}