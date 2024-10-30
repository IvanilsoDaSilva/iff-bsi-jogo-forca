package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoTexto implements Boneco {
	private static BonecoTexto soleInstance = null;
	private String[] partes = {"cabeça", "olho esquerdo", "olho direito", "nariz", "boca", "tronco", "braço esquerdo", "braço direito", "perna esquerda", "perna direita"};
	
	private BonecoTexto () {
		super();
	}
	
	/**
	 * Obtem uma instancia unica de BonecoTexto
	 * 
	 * @author IvanilsoDaSilva
	 * @return Instancia unica de BonecoTexto
	 */
	public static BonecoTexto getSoleInstance() {
        if (soleInstance == null) {
        	soleInstance = new BonecoTexto();
        }
        return soleInstance;
	}
	
	
	@Override
	public void exibir(Object contexto, int partes) {
		switch (partes) {
        case 10: {
            System.out.print("                                                                                                                     \\n\"\n"
            		+ "            		+ \"                                                                                                                     \\n\"\n"
            		+ "            		+ \"                                                                                                                     \\n\"\n"
            		+ "            		+ \"                                                                                                                     \\n\"\n"
            		+ "            		+ \"                                                                                                                     \\n\"\n"
            		+ "            		+ \"                                                                                                                     \\n\"\n"
            		+ "            		+ \"                                                                   ’                                                 \\n\"\n"
            		+ "            		+ \"                                     ˜›[3õûÿ8ãÆE¥UkUdÁÁb¾Y×                                                          \\n\"\n"
            		+ "            		+ \"                                 ·Îê±  –À7à¶¯           °UqãÕŽ{                                                      \\n\"\n"
            		+ "            		+ \"                                ez    ˜8R(                   !Údœ<                                                   \\n\"\n"
            		+ "            		+ \"                              ‚Ó¯    —Æ¼                       °€ïG~                                                 \\n\"\n"
            		+ "            		+ \"                             ³Ò     :ð’           ‘              S†b                                                 \\n\"\n"
            		+ "            		+ \"                             h³     ®>            Áº             )Oä;                                                \\n\"\n"
            		+ "            		+ \"                            Tv     óý             Bº              úê(                                                \\n\"\n"
            		+ "            		+ \"                           /ä     ²E*      SÖÛÔÖÖÙÆÐÔUv†—          ëÌ                                                \\n\"\n"
            		+ "            		+ \"                           ™“     &Ô              ã³               ¬ä                                                \\n\"\n"
            		+ "            		+ \"                           õ:     #1              ¥}                è‘                                               \\n\"\n"
            		+ "            		+ \"                           üˆ    nã‘              å1                3G                                      n)       \\n\"\n"
            		+ "            		+ \"                           üˆ    ÆŸ               U%                (Æ!                                     ±¯       \\n\"\n"
            		+ "            		+ \"                           ü¨   ·Æ3               ƒ%                 Æó        |?                           wº       \\n\"\n"
            		+ "            		+ \"                      §   `¾`   ²Æ*               ‹÷                 êw       µ‡D8UPO                       a’       \\n\"\n"
            		+ "            		+ \"                      U   ´ü    ¯Ê                                   k4     ìTM‹    ž:                      ¾`       \\n\"\n"
            		+ "            		+ \"                      U   ´ü    /Û    O8>³¾5ù jµs¢ñ    Ì0m±Sïsö öS   t4    tY KðkTåB„                      ;ú        \\n\"\n"
            		+ "            		+ \"                      û   ´a    JÊ    …õ+íƒ 9…a’ûÔË¼}) ´}Ú$^ÿ´à¦œè   ·&    ›K8Mð‘H  µ„                     ú<        \\n\"\n"
            		+ "            		+ \"                     ¨S    O;   ôêª   v&§…à8± }3>›¿    ¬±s@ãá€ú;)ô·  ·k     aRÁØ¶›  n{                     Ø         \\n\"\n"
            		+ "            		+ \"                     /ü    Y¯   ­õ1                                  ªÙ     z€* –N¾Sc                    ´ïš’’’’’’’… \\n\"\n"
            		+ "            		+ \"    )½½uµbbbÙbf1»»»»»ñÌ»»»»@½»îúñbÞ¶ÛêÐÛppÙÖÖÖäµ©@@u1i((¬¦¦¦¦¦¦¦¦¦¦¦¦ÎÞ^––––“ã¯––ã•––––º”!ï3§mÐßÿ6C/’‚    5;         \\n\"\n"
            		+ "            		+ \"            ¾ª       ’`               ˜!                                    ”ŽÿS€“              jo        4          \\n\"\n"
            		+ "            		+ \"            ¾ª                        ¢j                                    ¼J     u            µ‚       ˆ&          \\n\"\n"
            		+ "            		+ \"            ¾ª                        O/                                    ž*    ì£           ’ž                    \\n\"\n"
            		+ "            		+ \"            ¾ª                        •‚                `                   ÿ¯    ú…           ¯&             ’Í     \\n\"\n"
            		+ "            		+ \"            T“                     %C                  „e                   0½    ±                           ¯3     \\n\"\n"
            		+ "            		+ \"            û­                     %C        ´                               ½í                               ?o     \\n\"\n"
            		+ "            		+ \"            ”                      %Ì        µ}                              x¨                               u*     \\n\"\n"
            		+ "            		+ \"                                    Ó¨       í„                             ‡½                     „á         5“     \\n\"\n"
            		+ "            		+ \"                                    “Þ²                                    ˜Ã                      ¬P         ñˆ     \\n\"\n"
            		+ "            		+ \"                                                                           4–                       …                \\n\"\n"
            		+ "            		+ \"                                                            £             ³í                                         \\n\"\n"
            		+ "            		+ \"                                                           CC                                                        ");
        }
        break;
        
        
        case 9: {
            System.out.print("            ·/¹            \n"
            		+ "            ´(–            \n"
            		+ "            ´v—            \n"
            		+ "       `‚³×ƒtjc‡<—:¨       \n"
            		+ "    `:!»·         `^¬“`    \n"
            		+ "   ´(­               ´r…   \n"
            		+ "  ˜í`                  +º  \n"
            		+ " `7‘    X       X      …{‚ \n"
            		+ " ’/ˆ                   `°º \n"
            		+ " …¿‚        X          ´“­ \n"
            		+ "  ”„                   ’?` \n"
            		+ "  `³>       X         ¹?´  \n"
            		+ "    ¸»“´            ;}‹    \n"
            		+ "      ¸³*+‘`    …¡¿¯‘`     \n"
            		+ "          ³z[c<“           ");
            break;
        }
        case 8: {
            System.out.print("            ·/¹            \n"
            		+ "            ´(–            \n"
            		+ "            ´v—            \n"
            		+ "       `‚³×ƒtjc‡<—:¨       \n"
            		+ "    `:!»·         `^¬“`    \n"
            		+ "   ´(­               ´r…   \n"
            		+ "  ˜í`                  +º  \n"
            		+ " `7‘    O       X      …{‚ \n"
            		+ " ’/ˆ                   `°º \n"
            		+ " …¿‚        X          ´“­ \n"
            		+ "  ”„                   ’?` \n"
            		+ "  `³>       X         ¹?´  \n"
            		+ "    ¸»“´            ;}‹    \n"
            		+ "      ¸³*+‘`    …¡¿¯‘`     \n"
            		+ "          ³z[c<“           ");
            break;
        }
        case 7: {
            System.out.print("            ·/¹            \n"
            		+ "            ´(–            \n"
            		+ "            ´v—            \n"
            		+ "       `‚³×ƒtjc‡<—:¨       \n"
            		+ "    `:!»·         `^¬“`    \n"
            		+ "   ´(­               ´r…   \n"
            		+ "  ˜í`                  +º  \n"
            		+ " `7‘    O       O      …{‚ \n"
            		+ " ’/ˆ                   `°º \n"
            		+ " …¿‚        X          ´“­ \n"
            		+ "  ”„                   ’?` \n"
            		+ "  `³>       X         ¹?´  \n"
            		+ "    ¸»“´            ;}‹    \n"
            		+ "      ¸³*+‘`    …¡¿¯‘`     \n"
            		+ "          ³z[c<“           ");
            break;
        }
        case 6: {
            System.out.print("            ·/¹            \n"
            		+ "            ´(–            \n"
            		+ "            ´v—            \n"
            		+ "       `‚³×ƒtjc‡<—:¨       \n"
            		+ "    `:!»·         `^¬“`    \n"
            		+ "   ´(­               ´r…   \n"
            		+ "  ˜í`                  +º  \n"
            		+ " `7‘    O       O      …{‚ \n"
            		+ " ’/ˆ                   `°º \n"
            		+ " …¿‚        <          ´“­ \n"
            		+ "  ”„                   ’?` \n"
            		+ "  `³>       X         ¹?´  \n"
            		+ "    ¸»“´            ;}‹    \n"
            		+ "      ¸³*+‘`    …¡¿¯‘`     \n"
            		+ "          ³z[c<“           ");
            break;
        }
        case 5: {
        	System.out.print("            ·/¹            \n"
            		+ "            ´(–            \n"
            		+ "            ´v—            \n"
            		+ "       `‚³×ƒtjc‡<—:¨       \n"
            		+ "    `:!»·         `^¬“`    \n"
            		+ "   ´(­               ´r…   \n"
            		+ "  ˜í`                  +º  \n"
            		+ " `7‘    O       O      …{‚ \n"
            		+ " ’/ˆ                   `°º \n"
            		+ " …¿‚        <          ´“­ \n"
            		+ "  ”„                   ’?` \n"
            		+ "  `³>     ____        ¹?´  \n"
            		+ "    ¸»“´            ;}‹    \n"
            		+ "      ¸³*+‘`    …¡¿¯‘`     \n"
            		+ "          ³z[c<“           ");
            
            break;
        }
        case 4: {
        	System.out.print("=========''', '''\n"
            		+ "  +---+\n"
            		+ "  |   |\n"
            		+ "  O   |\n"
            		+ "  |   |\n"
            		+ "      |\n"
            		+ "      |\n"
            		+ "=========''']");
            
            break;
        }
        case 3: {
        	System.out.print("=========''', '''\n"
            		+ "  +---+\n"
            		+ "  |   |\n"
            		+ "  O   |\n"
            		+ " /|   |\n"
            		+ "      |\n"
            		+ "      |\n"
            		+ "=========''']");
            break;
        }
        case 2: {
        	System.out.print("=========''', '''\n"
            		+ "  +---+\n"
            		+ "  |   |\n"
            		+ "  O   |\n"
            		+ " /|\\  |\n"
            		+ "      |\n"
            		+ "      |\n"
            		+ "=========''']");
            break;

        }
        case 1: {
        	System.out.print("=========''', '''\n"
            		+ "  +---+\n"
            		+ "  |   |\n"
            		+ "  O   |\n"
            		+ " /|\\  |\n"
            		+ " /    |\n"
            		+ "      |\n"
            		+ "=========''']");
            break;
        }
        case 0: {
            System.out.print("=========''', '''\n"
            		+ "  +---+\n"
            		+ "  |   |\n"
            		+ "  O   |\n"
            		+ " /|\\  |\n"
            		+ " / \\  |\n"
            		+ "      |\n"
            		+ "=========''']");
            break;
        }
        default: {
            throw new IllegalArgumentException("Partes devem possuir um numero entre 0 e 10");
        }
    }
	}


}
