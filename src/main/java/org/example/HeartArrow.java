package org.example;

public class HeartArrow {
    public static void main(String[] args) {
        String text = "*";
        int index = 0;

        // 可调整参数
        int size = 18;      // 基础大小
        double scale = 1.5; // 宽高比例
        int width = 120;    // 控制台最小宽度要求（字符数）

        // 动态调整横向范围
        int xStart = (int) (-size * 2.2);
        int xEnd = (int) (size * 2.2);

        // 生成爱心图案
        for (int y = size; y >= -size; y--) {
            StringBuilder line = new StringBuilder();
            for (int x = xStart; x <= xEnd; x++) {
                // 精确心形方程
                double xScaled = x * 0.038 / scale;
                double yScaled = y * 0.09;
                double heart = Math.pow(xScaled*xScaled + yScaled*yScaled - 1, 3)
                        - xScaled*xScaled * Math.pow(yScaled, 3);

                // 动态边界检测
                if (heart < 0 || Math.abs(heart) < 0.2) {
                    line.append(text.charAt(index++ % text.length()));
                } else {
                    line.append(" ");
                }
            }
            // 居中对齐
            String paddedLine = String.format("%" + width + "s", line.toString());
            System.out.println(paddedLine);
        }
    }
}