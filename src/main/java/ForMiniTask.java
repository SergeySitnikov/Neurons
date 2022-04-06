public class ForMiniTask {
    public static void main(String[] args) {
        String service = " 'aol', 'auth', 'bgp', 'courier', 'csnet_ns', 'ctf', 'daytime', 'discard', 'domain', 'domain_u', 'echo', 'eco_i', 'ecr_i', ' efs ',' exec ',' finger ',' ftp ',' ftp_data ',' gopher ',' gather ',' hostnames ',' http ',' http_2784 ',' http_443 ',' http_8001 ', 'imap4', 'IRC', 'iso_tsap', 'klogin', 'kshell', 'ldap', 'link', 'login', 'mtp', 'name', 'netbios_dgm', 'netbios_ns', 'netbios_ssn ',' netstat ',' nnsp ',' nntp ',' ntp_u ',' pm_dump ',' pop_2 ',' pop_3 ',' printer ',' private ',' red_i ',' remote_job ', 'rje', 'shell', 'smtp', 'sql_net', 'ssh', 'sunrpc', 'supdup', 'systat', 'telnet', 'tftp_u', 'tim_i', 'urh_i ',' urp_i ',' uucp ',' uucp_path ',' vmnet ',' whois ',' X11 ',' Z39_50 '";
        String flag = "«OTH», «REJ», «RSTO», «RSTOS0», «RSTR», «S0», «S1», «S2», «S3», «SF», «SH»";
        createEnumFromString(service);
    }

    private static void createEnumFromString(String values) {

        String[] split = values.split(",");
        int i = 0;
        for (String s1 : split) {
            s1 = delNoDigOrLet(s1);
            s1 = s1.toUpperCase();
            String tmpString = "(" + i++ + "),";
            s1 += tmpString;
            System.out.println(s1);
        }
    }

    private static String delNoDigOrLet (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i)) || s.charAt(i) == '_')
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
