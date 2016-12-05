package com.example.aed.numberbases;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by aed on 25.10.2015.
 */
public class InfoPage extends Activity {

    ScrollView sv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_page);

        sv = (ScrollView)findViewById(R.id.scrollView);
        tv = (TextView)findViewById(R.id.textView3);



        tv.setText(Html.fromHtml("<html>\n" +

"<body>\n" +
"\n" +
"\t\t\t\t\t\t<b><em><h3>RADIX</h3></b></em>\n" +
"\n" +
"Etymology : Radix is a Latin word for \"root\". Root can be considered a synonym for base in the arithmetical sense.\n" +
"\n" +
"In mathematical numeral systems, the radix or base is the number of unique digits, including zero, used to represent numbers in a positional numeral system. For example, for the decimal system (the most common system in use today) the radix is ten, because it uses the ten digits from 0 through 9.\n" +
"\n" +
"In any positional numeral system (except unary, where the radix is 1), the number x and its base y are conventionally written as (x)_y, although for base ten the subscript is usually assumed and not written, as it is the most common way to express value. For example, (100)_{10} (in the decimal system) represents the number one hundred, whilst (100)_2 (in the binary system with base 2) represents the number four.\n" +
"\n" +
"\t\t\t\t\t\t<b><em><h3>BINARY</h3></b></em>\n" +
"\n" +
"In mathematics and digital electronics, a binary number is a number expressed in the binary numeral system or base-2 numeral system which represents numeric values using two different symbols: typically 0 (zero) and 1 (one). The base-2 system is a positional notation with a radix of 2. Because of its straightforward implementation in digital electronic circuitry using logic gates, the binary system is used internally by almost all modern computers and computer-based devices. Each digit is referred to as a bit.  \n" +
"\n" +
"<br/>see also : <a href = \"https://en.wikipedia.org/wiki/Binary_number\">https://en.wikipedia.org/wiki/Binary_number </a>\n" +
"\n" +
"\n" +
"\t\t\t\t\t\t<b><em><h3>OCTAL</h3></b></em>\n" +
"\n" +
"The octal numeral system, or oct for short, is the base-8 number system, and uses the digits 0 to 7. Octal numerals can be made from binary numerals by grouping consecutive binary digits into groups of three (starting from the right). For example, the binary representation for decimal 74 is 1001010, which can be grouped into (00)1 001 010 – so the octal representation is 112.\n" +
"\n" +
"<br/>see also : <a href = \"https://en.wikipedia.org/wiki/Octal\">https://en.wikipedia.org/wiki/Octal </a>\n" +
"\n" +
"\t\t\t\t\t\t<b><em><h3>DECIMAL</h3></b></em>\n" +
"\n" +
"The decimal numeral system (also called base 10 or occasionally denary) has ten as its base. It is the numerical base most widely used by modern civilizations.\n" +
"\n" +
"<br/>see also : <a href = \"https://en.wikipedia.org/wiki/Decimal\">https://en.wikipedia.org/wiki/Decimal </a>\n" +
"\n" +
"\t\t\t\t\t\t<b><em><h3>HEXADECIMAL</h3></b></em>\n" +
"\n" +
"In mathematics and computing, hexadecimal (also base 16, or hex) is a positional numeral system with a radix, or base, of 16. It uses sixteen distinct symbols, most often the symbols 0–9 to represent values zero to nine, and A, B, C, D, E, F (or alternatively a, b, c, d, e, f) to represent values ten to fifteen. Hexadecimal numerals are widely used by computer systems designers and programmers. Several different notations are used to represent hexadecimal constants in computing languages; the prefix \"0x\" is widespread due to its use in Unix and C (and related operating systems and languages). Alternatively, some authors denote hexadecimal values using a suffix or subscript.\n" +
"\n" +
"<br/>see also : <a href = \"https://en.wikipedia.org/wiki/Hexadecimal\">https://en.wikipedia.org/wiki/Hexadecimal </a>\n" +
"\n" +
"</body>\n" +
"</html>"));
        tv.setMovementMethod(LinkMovementMethod.getInstance());


    }

}
