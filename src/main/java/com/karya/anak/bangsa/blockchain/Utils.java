package com.karya.anak.bangsa.blockchain;

class Utils {
    static String zeros(int length) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append('0');
        } return builder.toString();
    }
}
