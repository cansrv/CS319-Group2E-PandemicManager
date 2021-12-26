package dutchChocolates.panMan.appLayer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import java.time.Clock;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RiskListener {


    private static void httpReq() throws IOException {
        URL url = new URL("localhost:4567/riskEval");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        boolean doPrint = true;
        while (true) {
            Date date = Date.from(Clock.systemDefaultZone().instant());
            String dateString = simpleDateFormat.format(date);
            try {
                Thread.sleep(59000);

                // 8.30
                if (dateString.contains("08:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("08:15:")) {
                    doPrint = true;
                }

                // 9.30
                else if (dateString.contains("09:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("09:15:")) {
                    doPrint = true;
                }

                // 10.30
                else if (dateString.contains("10:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("10:15:")) {
                    doPrint = true;
                }
                // 11.30

                else if (dateString.contains("11:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("11:15:")) {
                    doPrint = true;
                }
                // 12.30

                else if (dateString.contains("12:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("12:15:")) {
                    doPrint = true;
                }
                // 13.30

                else if (dateString.contains("13:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("13:15:")) {
                    doPrint = true;
                }

                // 14.30
                else if (dateString.contains("14:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("14:15:")) {
                    doPrint = true;
                }
                // 15.30
                else if (dateString.contains("15:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("15:15:")) {
                    doPrint = true;
                }
                // 16.30
                else if (dateString.contains("16:15:")) {
                    if (doPrint) {
                        System.out.println(dateString);
                        httpReq();
                        doPrint = false;
                    }

                } else if (!dateString.contains("16:15:")) {
                    doPrint = true;
                }

            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

