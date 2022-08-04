package algorithm.clock;

/**
 * 求：12小时内，时针和分针夹角为6度
 * 时针：360度/12小时 = 360度/(12*60)分钟= 0.5度/分钟
 * 分针：360度/60分钟 = 6度/分钟
 */
public class HourAndMinute {
    public static void main(String[] args) {
        double minute = 6;
        double hour = 0.5;

        double angle = 0;
        for (int i = 1; i <= 12 * 60; i++) {
            angle = Math.abs((minute * i) % 360 - hour * i);
            if (angle == 6 || 360 - angle == 6) {
                System.out.println(i / 60 + ":" + i % 60);
            }
        }

    }
}
