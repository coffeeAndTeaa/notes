package string;

public class StrStr {
    public int findSubString(String large, String small) {
        if (large.length() < small.length()) {
            return - 1;
        }
        if (small.length() == 0) {
            return 0;
        }
        int largePrime = 101;
        int prime = 31;
        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        for (int i = 1; i < small.length(); i++) {
            seed = moduleHash(seed, 0, prime, largePrime);
            targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
        }
        int hash = 0;
        for (int i = 0; i < small.length(); i++) {
            hash = moduleHash(hash, large.charAt(i), prime, largePrime);
        }
        if (hash == targetHash && equals(large, 0, small)) {
            return 0;
        }
        for (int i = 1; i <= large.length() - small.length(); i++) {

        }
        return 0;
    }

    public boolean equals(String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int moduleHash(int hash, int addition, int prime, int largePrime) {
        return (hash * prime % largePrime + addition) % largePrime;
    }

    public int nonNegative(int hash, int largePrime) {
        if (hash < 0) {
            hash += largePrime;
        }
        return hash;
    }
}
