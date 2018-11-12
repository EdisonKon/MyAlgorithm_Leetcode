package PalindromePairs;

import java.util.*;

/**
 * @description: 描述
 * @author: dekai.kong (dekai.kong@luckincoffee.com)
 * @date: 2018-10-24 15:12
 */

/***
 * //测试回文
 *     //https://leetcode.com/problems/palindrome-pairs/description/
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * */
public class TestPalindrome {
    public static void main(String[] args) {
        String arr[] = {"abcd","dcba","lls","s","sssll"};
//        String arr[] = {"bat","tab","cat"};
//        String arr[] = {"a","b","c","ab","ac","aa"};
//        String arr[] = {"a",""};
//        String arr[] = {"ab","ba","abc","cba"};
//        String arr[] = {"abcd","dcba","lls","s","sssll",""};
//        String arr[] = {"ib","cjcehd","dfjcahcehhdf","gh","ideabce","accfcdhjfhebigh","cbjchaeiiciefceg","hg","abj","dddcdjbefdeceedafhfi","jbgdi","aejbjiedecggdbbd","aejgcaabafbfiafi","a","fdb","fhbgcdjechabhg","bcdbajbdehibahecig","jfhadahhhaagjaaf","bagdeccgddaja","gchaaf","bgbbd","jjcgciihhfeageaadid","gdbedgc","ehbjfhgigdbiabgddhig","hjgdeiccfbgieb","cehhifiba","hdjjgjdbaeeedcgcdbf","fafejeiga","ecdcfaedjhcced","cghbibcagcijdhe","egbbehafiechcb","be","ji","geagddiccjeh","fjfc","dfhcgccccfbfbgdhejfe","jjcahegcicjgdbce","dfabhjjghjgddiaie","fijbcj","hbgefd","idd","ac","fjcjafhiiaggjbdica","ahidjficci","fefcdjiahcb","ijfaeajaeg","adjbfcee","ghcdfihifffdhehgje","fcf","jiaa","jbacghaghecdhfejfhe","chdbbjcfafa","badaiaeaabhhd","gefhhbihddg","haccghbagfddebhbheh","aidc","hgeedfbggdgcfhbgfc","idfedagdijf","idhfiiegebebaebbifbc","f","dhhfdeic","hafhigfeeddgihegdgg","cjge","hjaehejbidcddhhfb","bcjcefceebiegcac","igjdccccjeibagj","jafcdigedibbhhdh","ggchiaed","cgccbbbai","ghjajhfjdahebgbbga","cdfajhj","gbjbjffia","hfbciee","egggidabbae","bbe","ccjddfefcahfaf","acgdbgajgjeeieefh","ififgbbgigbahdacb","hhejdchie","bfjejjaiadgbic","dfjdabbidcgjc","iaccbb","fjdbhhdiifdibjcfj","efbcaafcihjfj","j","fagiiffcfiddai","fhjgfjebdfdgifeadg","cgaagcihhjg","aidacecgcce","fedfgcfefjjhhdjcbedd","higf","dghfacijijchbf","gbijbdbhbjh","ehh","hcecbjbjf","hfadhifdhdjijgiicdb","ghfaighbgj","hjcfbhhihiiidj","hgbjj","ae","hccfb","icfhcgi","hdjjfifa","bdjafhgdjdhfjbde","fbhjdghhcde","fdfiefgdibgbhc","i","jbfbficceabgbgjg","agigdbbbeahfahjbg","ffaiiagdjjgegeb","c","ijgjjab","gehdfjcigfgfig","ebgjdedidhb","fgfadjbficcjecga","hci","egbhi","fbga","dif","jbgjcbcagjedhgdhca","e","ihd","gfgadggfdfg","eabdcejeh","dheajbjfcgdbgiagi","jbfafcfahdjihhigda","iececeei","jhegd","aeibbadegjidafbdbfca","jedccabehdgad","jadfggfcihbie","chiijbfigiadcb","ba","hddcedhiebhdeehhaa","bhgbjiebfgbdjggbgbcf","bjb","abcaccecifdfjcjfiege","eibhbhcjffdbgja","iahjhgbfidahjcj","gahbbgjaicgb","gaehhiihajgebgcchdj","hd","ejfghbigchfg","ch","idfajahf","fheicdaieicgiaiaibe","hbch","dhghgdcbbaeghg","ddaabhji","eaehbjddgfeaaghg","bfhaiabcbbffe","haaffcjadeh","dbhiajjeidaiefhhd","gg","dibdjhbfbbedachji","ccfajgiciagadca","cccei","igdbe","jjjhj","gebeci","fadgbibgjcfbadccad","dgchfchci","jeaibcabibgddeg","edbcgdcjhggaddceg","hijcdbdhag","ihhegghdhagccebab","jdgghfidcbjcdiacg","ijbcafebi","hegjbfggebggjhjf","ahfbgfcd","ggdiaiaccfg","egjai","efffbifdaiecefcjbd","gaegagjeebbedcdjc","bhjebfiijbiacba","iaf","ffiaccjagficjah","dhjbdaebbigdbbcbe","dcfecachejgedcg","ijbhibdggiefbgfgd","bdhajigaaeif","id","bcbceiceedabgeee","gfcgcehjddjhhaa","cdaifiiecbjdacgafheb","ahdjii","abefadfjadgcdeaie","gedfjggbhejagcacafig","iiebagedbcbhj","jd","daficgheabdafbhjb","cicbiagahhjefiifcach","aceciciedjd","fidaajhbj","dacib","d","ajcfjiebbdghaaggj","fhbgbhbfc","idafccgi","ddbfecfcaadfchjidceg","cdggfbabgfcebfjfiaib","ceiafjffijcbfeecjfie","hfbdafdeahhdefddabce","hcfcbaieagjgecg","abbfiajehjbcigaaejhb","gccbieijijeggddi","bcgajjcbhjhdibeccgf","ghe","fj","diedbbhgjfggd","ici","eecbhgc","aagbjfgiaccacbcdjb","acgadcfdhaacge","gfhjbbhhdhcdhcej","hecdaedhbhffe","bihfgjffha","bbbjgbhdefhfde","ifcjefggjdaefj","dhajihieeiicjdd","afgcafbfebbfjjbba","jddddfccfbbgfefaf","cicb","hjfgaedadgbafjeee","faebfcc","hdjiaiacjaia","ajfdhhbjhhh","haeccchf","bhi","ajhbh","ejfecffajigjjegcae","fedffhbcbhjji","dcbcjdgjicg","bjdcicjgidcifiae","dfhiedidga","bdijahc","aifh","eebbdg","hhfb","ddfigeidhgjiaeheahh","hdccebbgagijgfed","efdahcibj","bajfjej","hebajecgacacbfgfbi","hfafabfddgbde","aadibihfj","hghaibgghjfgjdcc","dbdjhgiagbaicbeibh","jgcgciddfgjhcjiaigd","ijeacgfehaihcjegadhc","gieaadbedfg","gj","ghbdgbjgjieej","fbbjd","fg","bfjbceehjfbea","edbaahhhgbbeheb","cdjagaf","hcdechddcjjaabhhjb","fjggcagecffjafijic","gddhge","jicefdgejchefhfbfea","ha","jhf","hbagbjiihj","hh","ajh","cgbfgbfhbgfgfcjbjd","ahheficahajjdcbfc","cbdjcgfcefcbcaghic","ccig","jihcdigdbeefcgdhbj","hdhgfaafghaadehajcj","di","gdidejcaehb","ejjhfjeejiiaagb","abifhggfbfhcaecebbf","bdcfhejdiijah","bhdfbe","ijbjhjfgdgacfha","caegdgcbfibdcdeeifgh","faadjeic","iaabgfcdcebibjbhd","aidcdhegehcebg","iffbbi","jhefbefad","gfi","fafci","eifhbdfhdahhgiafage","bdghehedgcfejbf","agajfejdjcdeeehidf","jbhjdcfjfbbchbbhdhb","hdej","ig","fbifcjcdfgdeef","iec","ihbjhcfdjdgeb","effhhedficacbici","ejac","geeefccifaf","ga","jbfghefdgf","dfcdgedhiggcgcedbfic","jcgegibefjihaf","ddcicabhieegi","hijeb","gbcifig","gbaciadfeahcjghicdae","ihbgabajhejbcjjb","bch","dedgddfdaih","idcihhdeeahaebha","efbjchegihijabj","jbhjdbafbiadidahce","dafhbbdcibibbhhahe","djfaebhibegejb","hfhgcjjdbdjbadhf","adf","hdcicbhfechij","abaajhfai","cghijaa","hiiahehjiafjibdg","ajjaajheiecijh","ceeb","fjabbdc","diehf","jjbeiajjddebbbgaae","fhdbghhebjcbfedcdhab","iaafdifggcagc","dacihddijeeeibaghjah","cdcfagaabdgdcc","jigghbb","aehfe","hhcecfacijafigbfij","deebcfhhaejhic","ggadgijafe","hchcijfebffi","hiib","jgfbgaffgcjbe","ieagccjccgfj","bcbddiijjfd","iaeed","cebagdhiifibadibhje","bj","bggeegigjcffb","dcbegfbi","ijg","aicdebcdhhigb","hdjbidahjdeegihjci","jffjdfedcfiaa","aggdiechjhhegc","fibhbifaifihehjf","daea","ciccaafehgbhd","faeejaihicahbbj","iebaciegbgibfdgdba","accejcdjgfidiaa","bhfddfjfgied","bhhigf","ijbbaeeg","fcbfja","ceffadbefbajadihgd","hajfcgjha","jbdcbgeii","ebeacgdi","adcccc","bdjhbbdhg","chedaacifgdbibac","afgdhgbgjcgfiafjjfd","ffcg","becfedjgaj","gegaabbccfdfffgbiffb","dfdchbhd","igeacjbbfcf","ccc","iiefahbcgceghee","jihjgdcedbd","icbcacdjefbchgfdg","iaigcabhfhhigbdcahbc","jbhaeddb","cbedce","gjhjjdjghhbgajccabcg","ejcff","fgaachhbbaf","fcgffffgg","fdea","cihafahcbhig","digbebafccd","dighcdfcicgeeg","jeacffedhdjaaff","fdcibf","haaidaejdgfigjcaeeha","hfgegcgejjjgdjjeaj","bcadifdcfca","jeh","abejjdhijbb","jieieagjejfijafec","ghceaeb","ceejd","bcjjddbfcfageciai","hdcdj","hddebdbi","hecaecijgcicah","dae","jdfhhgjfgc","ggebjf","gfaijbe","bibcdibjjf","chajajfa","aahdi","dbgd","ccic","difjigfbgec","agfhecgjdhgef","hafefegeje","jdabbdcefghdhibc","abcjabdjcecjjdb","feggh","aigdejdidjj","jedbfcc","ibicbfe","jdehbhbaaejfcb","fabghhef","affjcfjjidifjdfgbbgc","icifcigcbcdiagbgeif","biicjhbhidee","ccgacbigjcaj","ccadfaabjh","bhicfgfa","hadgjebaiehiagb","df","jdbefi","dfaciafibecejigig","fgjdaj","cgagifjijfdjcheabbf","igcdedjjjaha","dig","gfgdcgibjjgibjjicc","aehjd","hihdeadh","jfjicafaabiegcfa","bcadfgefbh","dbdaeh","af","afaijhdjfdeghbjihe","figedggaj","jdcchdadhifa","fgddfdeeehebfhde","efj","edcgaidb","h","hfjfdcjihgbhadefdacf","beiaabedjadigceejfb","bceibjdiabfgfjdib","fhbbbdeghajefeacff","hjfde","gbcbegafj","b","bhedfiiifcggfaiff","gciegghhdg","ieead","ee","jafaajafddeifgdeggh","cgcbh","fcahcjdcbe","ehcgcibbf","jgceecihfdceahhc","dbahabcdajcbfacb","aaaj","ceicab","ghiea","jagfaiidhg","ijefjbachdihidida","cfhgeeaii","jbidfhbec","ahehjajehgj","eh","gaijibbibfcgfh","hgjdcgbhbhcgcghdhd","jdagecifahaheaj","cejheaihbajcgdjb","jecbiiagebegcgabg","caajbdigciaihabde","ffdcigijbhjdc","jbaigdhhibhfbdiejf","achgebbicjfhjdja","jebcejeifiacbaefggg","cihbieigbbidccc","dgbhbagehfjigeba","iii","abce","fjc","hgjgdhhajghciegga","ejaeaa","bjiej","jfffhaaejhdii","ddjh","hha","ahfefgbf","giijdjj","jadjjgdajbbgg","eggfei","bcbjejcecff","gbdbfbadidehea","eifbeeefebhbbfebaj","hfccaddhjgfhhajjfb","iffhbfad","ccicdbfcaifefcecjjdf","jg","gfjajbcb","faagjihb","jjbjdibggeh","ecbdcabhe","ggicjebfbcdbiajhhi","hiejbbdhbgbgafifei","aeecjebdjdcdejggdabh","hddcjchcbifad","bibafbdib","acchefiacgbebijg","efjggjjgfffffie","cbdagecfaebhgbdficd","gfebceie","fbjdejdjf","jbejifcdghhaajhhjbb","degijf","eihca","hihefajifaehefh","ifegcdgjf","hgbjhigabdfhhhgib","eidhja","iihhbbhbid","dcijfcgjhicjg","icjfdigeicgjgjaj","gicfcccfjgibajji","agfcc","geifabacai","aciifafejdf","ebji","ej","bhidggaiajjcda","jfhdf","ggdbggeafahdfdjjibh","fiicegbijjegghchfhcg","igfif","fhjbhdfjdieafh","ijhgbdgja","fbaehceajgi","dbihcdhccjbgcdhhh","dd","hgbjhhgea","dfefgb","jjhacbfg","higjficicfceaec","bifbgaefjbbcffabbci","fagdg","ffeigjiccahccddbedhd","hegjgee","iajgeihdf","hheceee","jdjiebiadjfcbc","ehejd","ehajcicg","gdhigcddjgjjgijgeaaa","ijeaabeidibcaad","achhagfbg","ejfcifffegeg","djjfaeedf","fcjd","ihgggaddhidfeged","hhcgjggbdfbibacagef","jcgcbdhbeejcdfbj","fbchddadghdbfbijaca","cbhfajadgdj","iafihbjefjaijgi","hbb","fjj","abcabgca","gdaihdj","idj","gibhbjdhccfjadjgjid","gd","ifdjhicgeheghieccba","jigcificcdecfj","hcdhaje","efdjg","beacjddiacah","fcehddbjd","cdigdhcdjcf","digahfgiiaaihgi","ciachfed","ehejicgcidjiaeeddffb","accjgcdhcajifagh","jc","gcghhjcehj","ieghicdbhce","eeb","ibehhchdjahcegjgb","jeegfdaeha","gahgbb","jihijfijfjgdiehcbj","dbbdiciihcc","jhiahdfgajgjchcg","acbcadggaag","hdjfdigcaiaba","gfjicf","egfaeaahcijfai","cjfebjaagbcdhihadded","dihjg","gccbbbh","dda","hehcjgcfbijhfbi","hhdaghjgccdggg","cccdfi","gbiifibbegbeeeb","ic","ied","agiibe","hcccgdcecg","fibjcbjdajgjhdaadhhi","ccafd","baccehffdgahfeafcjhh","ccidbjfeecidgijadg","acbgfggfjjddeac","fe","jgheebbchieh","aegifffehebjadeb","ahage","gddfb","cjjb","iccjajicacebghiaf","dabicfjjgef","jfjcjigfie","ghhbadchbjcbchbided","ifedifdjdcifeebcjh","fbajef","dghjhbhbgdeafa","ahbaajd","ccadhaicgbdcggiibdfi","chcihgdcici","eggiihbfbjfhbdfahj","dgjgegadh","jhjdja","ahjjdfhbhdehhaihc","icgcjaeibcfebg","cfceffcdbi","bcccga","eahjggffbbecae","jigahhh","jdi","jdgabiiidjagj","hajigadgacfcjbahiba","ebahc","cdbbgjdjehgef","fcadcgh","ghcacabaj","igijiechadbghhbfb","jjb","aedd","ebjgeegaaci","cdajdfhjhcj"};
//        String arr[] = {"fjdhdb","ahaaiddgfgddecdd","g","acbh","hfcjifbbgejaaeidbeeg","egjbgffbada","dgigeaijafcdbbhdebj","fiegjibadiejehhjeeg","icajiciee","iidbfdjgaafecdj","gcjdbidecahbfjjb","jec","gifdeeaajffj","faajbdhijiifjgeeec","fjb","afaadihebidfbcbgj","f","gbiecjfbeahddfc","bffgcgfbddfcef","egijebjh","egbfeifcgij","dfbjhdhgeicfbff","hbeiefghiee","dgb","bcfdfjhijjjcifade","hacedh","jhjhfjij","ic","gdidchffeeif","jadbbjfdfdgid","b","ciaejbedfegaidha","abjja","fhbjagh","chfjjg","ehgdeiaifhgjfcbe","aihbaggacihjaiie","gdacggbceeiai","ichaagbfiiccccjfadc","dccefhebdiaabaddb","eijcfed","jdcgbjehghbjibfbfgh","ce","bigafcihgeidbjjdjj","bjiieichidfidij","hecbg","ccjhbcdfdaahdaiefged","hjaigafaibjifdahcj","edbfjh","bfdjbhcdgfajajd","eiedde","ccd","hgdhfiegiccgghabgc","be","ffcbbah","efgiabeeecehacehiebe","cabjedjiacaabbcecd","eegfdhfe","h","jbhihjbfhgdd","djihhdgaecjhbjcjeedg","fbjgjbch","ihgja","eggjeagaffchcj","cihjhhabi","ifba","djgebgge","cgfigag","haagfegghgacjijjfb","fghifedehiicec","jcjbhhicdhiahd","eai","gaeiiifcfgi","ggbfih","if","bcgcihgbcgicbfagbeic","jgedjjhihdeihgg","cddcgddiigf","acbdicdjbhej","ehacf","giebcfjbbjigj","jheceafeagjbiihh","ghhcccjajehhajafcajd","jdhajef","bfghgfhdeeafgiegcb","bheiceh","fgddf","gdjgiihifijfgefcgdae","jibdfhjf","gjaeigiefdhbc","ghidg","aicdfeiidd","gbha","ccjb","bijgibjedehfijbicgb","ciej","bijdeibgicehia","ajfhj","icdcbhhhifhh","haeaeaggdefjfagfa","bebjabhbaijhag","agbedijjc","gifihgdgfbjedfc","djcbbieaadbig","gadgejhjgechbbdhj","egacjhaeaehjfchahfdf","hdjjgibdfficbbi","dfgfdbaajajhc","cjdfaahffjbfgdfej","cgfif","hibafgegaahgejbh","ifgbihah","cgieagifija","ahbjidgdibbdjfgcdfjf","cigbhadeidiicjiagif","beiddjb","ccecec","aefddcefgedf","bgig","fafaaeaheddjajigg","igefhhhdcgfgjgei","jhifahchagcc","cf","bhjhcbcgaefbd","bcijaahhcchh","eghjgc","hccjjhdffdd","jbgchdijidfabfeejhf","fbabfaffdaeiabcd","igdjcbijghcehghhegb","iddhbegedhfgagf","eg","ceafb","cibfchgegegeegij","fhc","cdbaid","hihdbijbaccab","idhbgbhcjdih","aebijeicgdcbbgbech","efcfchbi","d","fcjjhggbhiaigchhih","jdfaafcidfi","dchbfhbdha","eiif","ffadhjjfhabejage","bajeffjccb","ghiabihgicfhajdbijj","jgfijafhdhjaihcgc","jedfhjeihb","jeba","egccdichiicfedeegc","dedbhcjffgj","ghehhcdjijhghejihe","jbjeeehajgiighgfhj","ecegddibhgdbhe","geijibjifjhbdibe","ffceaeadhaigffahj","feijgiidi","ghejahihgha","hdiijadf","dejaidibgg","a","dbh","ga","ejahbdhjgi","gjadchfcgja","egbfah","hcaahjd","gfj","dhc","fijbdjc","ifhiaaddddcagae","gbeiaafebdcagd","ajiehffaficcdieeebgg","ahagebiggi","hhaa","aiihfiefjaicbbbc","cieeiicajaeadd","hddfddffdhbaecejhfd","bdbhbcjiabdiaefeeh","gddabdiggecbf","acjcgbhgbbcgdejefa","abjdh","aeiac","gfbgfceij","ccfbeffjbdghahbaff","jieggdhcag","eiagdchhjgh","fbjfiagjf","hfddigjgdcifccdi","gihgbhgehbfghgccej","jjedbddf","ieajachii","gbgiaagdfj","eafjifffejeebahae","idgjhgjiahbba","ehchihhdbbbceaghhic","jiaaaifhefegajfhcah","hjehgg","feehbiigeechdbjhfdig","jiccegdfgafaij","chcdcfeefaj","eachhbch","bdaaefdjehgchbgjaf","j","iejeb","bdiabheabfffbibdhgei","hbgbcjihedgig","ch","eiacejifdbjdgf","jfjagcabfjebefhbc","cdhg","dagciafbieidjhaehej","ggaiifiacgfjhehdi","edcffabge","gedeecfefjiijheiijah","jge","hdjcbhejehge","gjiaffdcfej","dchgicedebiaafdbdiha","jcfaeffhidd","ebihchidchci","giecfgbd","cedjcfedahea","ifdjeg","gbdhfgaagegcidebh","hfhjbaffdjbfg","iidihbg","eeiihhihabb","dghf","hidbecc","ijgbfhccfahchgf","ecfhj","eifbgaheieegi","cceiaedbgcagihciacc","bdbhffcdfggeieiccfae","aaadhgcgidbjegd","egd","eccbcfccaceceddfhdfh","hdihcaijhhjbcigbjgjf","hijifehciafe","i","aejebjejgbjbacjdj","babjah","jeaiigeigdh","gbdecaf","idgdjhhjhcgafc","hejedcbdjihhaiehih","iigbic","cjh","ccaad","ajjjgjf","jbd","baggcg","afgdhjbcbji","ebfbdddceeib","jbcb","dajeggajhdhajfbdj","cecegegcabaiifd","fhibgcjfbfchfda","gddddciagafjfejagda","bifjdhggh","hbfafbdciecgijcge","abdf","hdbd","jei","jjfdebda","ae","ifccbidaaigeh","efdib","afjffgcehjcjbg","hdbeee","ejfajjfhef","iee","dgacjhficcichbiga","hhghjceicjjbbej","aahdibfdhjb","hhbjefbch","geifhebbfgebfehdab","ejgheadchhd","jbej","hh","fhigeahiighhia","jgcgbhjgcegag","dfdhiebciiahdh","hjhii","aghdbfhhjjcg","ihceifhahhbjea","jgcjiaiiebaci","chdbfdcii","igheb","dgei","iaie","bdaibdcbaagffee","ceiggfdbfdfgei","fabdhcggdda","ibddedbjccdj","bf","dcdaca"};
//        doxx2(arr);
//        List<List<Integer>>  lists =  doxx3(arr);
        List<List<Integer>>  lists =  palindromePairs(arr);
        System.out.println(lists);
    }

//hashmap就是切分arr[i] 然后如果arr[i]_left是个回文 然后arr[i]_right的reverse在hashmap里而且不是他自己 就ok了
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<=words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isBack(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.get(str2rvs)!=null && map.get(str2rvs) != i){
                        ret.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }
                if (isBack(str2) && str2.length() != 0) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.get(str1rvs)!=null && map.get(str1rvs) != i){
                        ret.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return ret;
    }
    public static boolean isBack(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }




    public static List<List<Integer>> doxx3(String arr[]){
        List<List<Integer>> a = new ArrayList<>();
//        Map<String,Integer> mapKv = new HashMap<>();
        Map<String,Integer> mapKv2 = new HashMap<>();
//        for (int i=0;i<arr.length;i++){
//            mapKv.put(arr[i],i);
//        }
        //判断map里是不是有回文
        /*for (int i=0;i<arr.length;i++){
            String xl = new StringBuffer(arr[i]).reverse().toString();
            int exist = mapKv.containsKey(xl)?mapKv.get(xl):-1;
            if(exist!=-1&&exist!=i){
                a.add(commAdd(i,exist));
            }else{
                mapKv2.put(arr[i]+xl,Integer.parseInt(i+""+exist));
            }
        }*/
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(i==j)continue;
                String fin = arr[i]+arr[j];
                if(mapKv2.get(fin)!=null&&mapKv2.get(fin)==Integer.parseInt(i+""+j))continue;
//                if(arr[j].equals(xl))continue;
//                String xre = new StringBuffer(fin).reverse().toString();
                if(isBack(fin)){
                    a.add(commAdd(i,j));
                }else{
                    mapKv2.put(arr[i]+arr[j],Integer.parseInt(i+""+j));
                }
            }
        }
        return a;
    }

    public static List<Integer> commAdd(int a,int b){
        List<Integer> inner = new ArrayList();
        inner.add(a);inner.add(b);
        return inner;
    }
    public static void traverseAdd(String xl,String arr[],List<List<Integer>> a,int i){
        for (int j=0;j<arr.length;j++){
            if(i==j)continue;
            if(arr[j].equals(""))continue;
            if(arr[j].equals(xl))continue;
            String x = arr[i]+arr[j];
            int half = x.length()/2;
            String xr = "";
            String xls = new StringBuffer(x.substring(0,half)).reverse().toString();
            if(x.length()%2>0){
                xr =  x.substring(half+1,x.length());
            }else{
                xr =  x.substring(half,x.length());
            }
            if(xls.equals(xr)){
                a.add(commAdd(i,j));
            }
        }
    }


    //out time
    public static List<List<Integer>> doxx(String[] arr) {
        List<List<Integer>> a = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(i==j)continue;
                String x = arr[i]+arr[j];
                int lenx = x.length();
                int half = lenx/2;
                int left = half;
                int right = half;
                boolean isEqual = true;
                if(lenx%2!=0){
                    while(isEqual && left>=0){
                        if(x.charAt(left--) != x.charAt(right++)){
                            isEqual = false;
                        }
                    }
                    if(isEqual){
                        List<Integer> inner = new ArrayList();
                        inner.add(i);
                        inner.add(j);
                        a.add(inner);
                        System.out.println("i:"+i+"   ----   "+"j:"+j);
                    }
                    continue;
                }else{
                    int k = 1;
                    while(k<=half && isEqual){
                        char xij = x.charAt(half-k);
                        char xijo = x.charAt(half+k-1);
                        k++;
                        if(xij != xijo){
                            isEqual = false;
                            break;
                        }
                    }
                    if(isEqual){
                        List<Integer> inner = new ArrayList();
                        inner.add(i);
                        inner.add(j);
                        a.add(inner);
                        System.out.println("i:"+i+"   ----   "+"j:"+j);
                        continue;
                    }
                }
            }
        }

        return a;
    }
//翻转字符串 outtime
    public static List<List<Integer>> doxx2(String arr[]){
        List<List<Integer>> a = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(i==j)continue;
                String x = arr[i]+arr[j];
                int half = x.length()/2;
                String xr = "";
                String xl = new StringBuffer(x.substring(0,half)).reverse().toString();
                if(x.length()%2>0){
                    xr =  x.substring(half+1,x.length());
                }else{
                    xr =  x.substring(half,x.length());
                }
                if(xl.equals(xr)){
                    List<Integer> inner = new ArrayList();
                    inner.add(i);inner.add(j);
                    a.add(inner);
                    System.out.println("ix:"+i+"   ----   "+"jx:"+j);
                }
            }
        }
        return a;
    }



}
