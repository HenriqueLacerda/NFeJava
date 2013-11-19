/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moveti.erpmove.fiscal.nfe;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Henrique
 */
public class _Funcoes
{
    private static SimpleDateFormat formatIsoS = new SimpleDateFormat("yyyyMMdd");
    private static SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat formatBra = new SimpleDateFormat("dd/MM/yyyy");
    private static Date date;

    public static String parseDataIsoSI(String dataIso)
    {
        try
        {
            if (!dataIso.isEmpty())
            {
                date = formatIso.parse(dataIso);
                return (formatIsoS.format(date));
            }
            else
            {
                return "";
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return ("Erro no parser da data");
        }
    }

    public static String parseDataIsoS(String dataBra)
    {
        try
        {
            if (!dataBra.isEmpty())
            {
                date = formatBra.parse(dataBra);
                return (formatIsoS.format(date));
            }
            else
            {
                return "";
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return ("Parse Date Error");
        }
    }

    public static String parseDataIso(String dataBra)
    {
        try
        {
            if (!dataBra.isEmpty())
            {
                date = formatBra.parse(dataBra);
                return (formatIso.format(date));
            }
            else
            {
                return "";
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return ("Parse Date Error");
        }
    }

    public static String parseDataBra(String dataIso)
    {
        try
        {
            if (!dataIso.isEmpty())
            {
                date = formatIso.parse(dataIso);
                return (formatBra.format(date));
            }
            else
            {
                return "";
            }
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return ("Erro no parser da data");
        }
    }

    public static boolean ValidaCpfCnpj(String s_aux)
    {
        System.out.println(s_aux);
        s_aux = s_aux.replace(".", "").replace("-", "").replace("/", "");
        //------- Rotina para CPF
        if (s_aux.length() == 11)
        {
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++)
            {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
                //--------- Multiplique a ultima  casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                d1 = d1 + (11 - n_Count) * digitoCPF;
                //--------- Para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                d2 = d2 + (12 - n_Count) * digitoCPF;
            }

            //--------- Primeiro resto da divisão por 11.
            resto = (d1 % 11);
            //--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2)
            {
                digito1 = 0;
            }
            else
            {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
            //--------- Segundo resto da divisão por 11.
            resto = (d2 % 11);
            //--------- Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            if (resto < 2)
            {
                digito2 = 0;
            }
            else
            {
                digito2 = 11 - resto;
            }
            //--------- Digito verificador do CPF que está sendo validado.
            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
            //--------- Concatenando o primeiro resto com o segundo.
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
            //--------- Comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
            return nDigVerific.equals(nDigResult);
        }
        //-------- Rotina para CNPJ
        else if (s_aux.length() == 14)
        {
            int soma = 0, dig;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();
            //--------- Primeira parte
            for (int i = 0; i < 4; i++)
            {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
                {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++)
            {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
                {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);
            //--------- Segunda parte
            soma = 0;
            for (int i = 0; i < 5; i++)
            {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
                {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++)
            {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
                {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        }
        else
        {
            return false;
        }
    }

    public static String PreparaFloat(String Valor)
    {
        return Valor.replace(".", "").replace(",", ".");
    }

    public static boolean VerificaConexaoInternet()
    {
        try
        {
            java.net.URL mandarMail = new java.net.URL("http://www.google.com");
            java.net.URLConnection conn = mandarMail.openConnection();

            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) conn;
            httpConn.connect();
            int x = httpConn.getResponseCode();
            if (x == 200)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (java.net.MalformedURLException urlmal)
        {
            //_ExibicaoErro.ShowError(urlmal);
            return false;
        }
        catch (java.io.IOException ioexcp)
        {
            //_ExibicaoErro.ShowError(ioexcp);
            return false;
        }
    }

    public static String FormataNumerico(String Conteudo, int Tamanho, int TamanhoDecimal)
    {
        String NovoConteudo;
        if (Conteudo.contains("."))
        {
            System.out.println(Conteudo);
            String Buffer[] = Conteudo.split("\\.");
            System.out.println(Buffer[0]);
            System.out.println(Buffer[1]);
            NovoConteudo = Buffer[0];
            NovoConteudo += ".";
            NovoConteudo += _Funcoes.CortaString(Buffer[1], 2);
            TamanhoDecimal = TamanhoDecimal - Buffer[1].length();
            //System.out.println("TAMANHO DECIMAL "+TamanhoDecimal);
            for (int i = 0; i < TamanhoDecimal; i++)
            {
                NovoConteudo += "0";
            }
        }
        else
        {
            NovoConteudo = Conteudo;
            NovoConteudo += ".";
            for (int i = 0; i < TamanhoDecimal; i++)
            {
                NovoConteudo += "0";
            }
        }

        /*for (int i = 2; i < TamanhoDecimal; i++)
        {
        Buffer += "0";
        }*/

        /*String BufferD;
        String Cont[] = Conteudo.split(".");
        System.out.println(Cont.length);
        if (Cont[1].length() < TamanhoDecimal)
        {
        BufferD = Cont[1];
        for (int i=BufferD.length(); i <= TamanhoDecimal; i++)
        {
        BufferD += "0";
        }
        Buffer = Cont[0] + "." + BufferD;
        }*/
        return NovoConteudo;
    }

    public static String FormataString(String Conteudo, int Tamanho)
    {
        if (Conteudo.length() > Tamanho)
        {
            Conteudo = Conteudo.substring(0, Tamanho);
        }
        else
        {
            String Buffer = "";
            for (int i = 1; i <= (Tamanho - Conteudo.length()); i++)
            {
                Buffer += " ";
            }
            Conteudo = Conteudo + Buffer;
        }
        return Conteudo;
    }

    public static String CortaString(String Conteudo, int Tamanho)
    {
        if (Conteudo.length() > Tamanho)
        {
            Conteudo = Conteudo.substring(0, Tamanho);
        }
        return Conteudo;
    }

    public static String FormataString(String Conteudo, int Tamanho, String Preencher, String Lado)
    {
        if (Conteudo.length() > Tamanho)
        {
            Conteudo = Conteudo.substring(0, Tamanho);
        }
        else
        {
            String Buffer = "";
            for (int i = 1; i <= (Tamanho - Conteudo.length()); i++)
            {
                Buffer = Preencher + Buffer;
            }
            if (Lado.equals("E"))
            {
                Conteudo = Buffer + Conteudo;
            }
            else
            {
                Conteudo = Conteudo + Buffer;
            }
        }
        return Conteudo;
    }

    public static String RemoverAcentuacao(String Conteudo)
    {
        Conteudo = Conteudo.replace("ç", "c");
        Conteudo = Conteudo.replace("Ç", "C");
        Conteudo = Conteudo.replace("á", "a");
        Conteudo = Conteudo.replace("Á", "A");
        Conteudo = Conteudo.replace("à", "a");
        Conteudo = Conteudo.replace("À", "A");
        Conteudo = Conteudo.replace("é", "e");
        Conteudo = Conteudo.replace("É", "E");
        Conteudo = Conteudo.replace("è", "e");
        Conteudo = Conteudo.replace("È", "E");
        Conteudo = Conteudo.replace("í", "i");
        Conteudo = Conteudo.replace("Í", "I");
        Conteudo = Conteudo.replace("ì", "i");
        Conteudo = Conteudo.replace("Ì", "I");
        Conteudo = Conteudo.replace("ó", "o");
        Conteudo = Conteudo.replace("Ó", "O");
        Conteudo = Conteudo.replace("ò", "o");
        Conteudo = Conteudo.replace("Ò", "O");
        Conteudo = Conteudo.replace("ú", "u");
        Conteudo = Conteudo.replace("Ú", "U");
        Conteudo = Conteudo.replace("ù", "u");
        Conteudo = Conteudo.replace("Ù", "U");
        Conteudo = Conteudo.replace("ã", "a");
        Conteudo = Conteudo.replace("Ã", "A");
        Conteudo = Conteudo.replace("â", "a");
        Conteudo = Conteudo.replace("Â", "A");
        Conteudo = Conteudo.replace("ê", "e");
        Conteudo = Conteudo.replace("Ê", "E");
        Conteudo = Conteudo.replace("õ", "o");
        Conteudo = Conteudo.replace("Õ", "O");
        Conteudo = Conteudo.replace("ô", "o");
        Conteudo = Conteudo.replace("Ô", "O");
        Conteudo = Conteudo.replace("ä", "a");
        Conteudo = Conteudo.replace("Ä", "A");
        Conteudo = Conteudo.replace("ë", "e");
        Conteudo = Conteudo.replace("Ë", "E");
        Conteudo = Conteudo.replace("ü", "u");
        Conteudo = Conteudo.replace("Ü", "U");
        Conteudo = Conteudo.replace("\"", "&quot;");
        Conteudo = Conteudo.replace("\'", "&#39;");
        Conteudo = Conteudo.replace("\\", "");
        Conteudo = Conteudo.replace("º", "");
        Conteudo = Conteudo.replace("ª", "");
        Conteudo = Conteudo.replace("§", "");
        Conteudo = Conteudo.replace("£", "");
        Conteudo = Conteudo.replace("¢", "");
        Conteudo = Conteudo.replace("&", "&amp;");
        return Conteudo.trim();
    }

    public static boolean zipar(String arquivoOriginal, String arquivoZip) {
        byte[] buf = new byte[1024];
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(arquivoZip));
            FileInputStream in = new FileInputStream(arquivoOriginal);
            out.setLevel(5);
            out.putNextEntry(new ZipEntry(arquivoOriginal));
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.closeEntry();
            in.close();
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
}
