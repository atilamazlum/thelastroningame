package maceraoyunundenemeseyleri;

import java.awt.Color;
import java.awt.Container;
import java.awt.Event;
import java.awt.Font;
impoava.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.desktop.AboutEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.security.PublicKey;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

public class Game {
JFrame window;
Container cont;
JPanel barJPanel, starbutonJPanel, maintextpanel;
JLabel titlenamesJLabel, kilicJLabel;
JButton start;
JTextArea mainJTextArea; // ?
/// ikinci sayfa için
JPanel choicePanel;
JButton choice1, choice2, choice3, choice4;
/// tepdeki bar işte
JPanel playerpanel; // tepedeki hp yeri
JLabel hpJLabel, weaponJLabel, hpnumberJLabel, weaponumberJLabel, moneybarJLabel, moneynumber;
int money;
int playerhp, vikinghp, wizardhp;
String weapon, position;
int silvering;

tittlescreenhandler tsh = new tittlescreenhandler();
chosehandler chs = new chosehandler();

public static void main(String[] args) {

new Game();

}

public Game() {
window = new JFrame("ADVENTURE GAME");
window.setSize(800, 600);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.getContentPane().setBackground(Color.black);
window.setLayout(null); /// yazının yerelrini biz koycaz ondan otamtik yapcaz
window.setVisible(true);

cont = window.getContentPane(); /// windowun içine containeri koyduk işte

barJPanel = new JPanel();
barJPanel.setBounds(100, 100, 600, 150);
barJPanel.setBackground(Color.black); /// maviyddi
cont.add(barJPanel);

titlenamesJLabel = new JLabel("ADVENTURE GAME");
titlenamesJLabel.setForeground(Color.white);
titlenamesJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
barJPanel.add(titlenamesJLabel);

kilicJLabel = new JLabel("▬▬ι══════ﺤﺤ");
kilicJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60));
kilicJLabel.setForeground(Color.white);
barJPanel.add(kilicJLabel);

starbutonJPanel = new JPanel();
starbutonJPanel.setBounds(300, 400, 200, 100);
starbutonJPanel.setBackground(Color.black);
cont.add(starbutonJPanel);

start = new JButton("start");
start.setForeground(Color.white);
start.setBackground(Color.black);
start.setFont(new Font("Times New Roman", Font.PLAIN, 30));
start.addActionListener(tsh);
start.setFocusable(false); /// hani start butonun içiinde kare çıkıyor ya onu götürüyor

starbutonJPanel.add(start);

}

public void gamecreen() {
titlenamesJLabel.setVisible(false); /// bu divler yok olmalı işte
starbutonJPanel.setVisible(false);

maintextpanel = new JPanel();
maintextpanel.setBounds(100, 100, 600, 250);
maintextpanel.setBackground(Color.black);
cont.add(maintextpanel);

mainJTextArea = new JTextArea();
mainJTextArea.setBounds(100, 100, 600, 250);
mainJTextArea.setBackground(Color.black);
mainJTextArea.setForeground(Color.white);
mainJTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
mainJTextArea.setLineWrap(true); /// çok uzunsa cümle kesiyor
maintextpanel.add(mainJTextArea);

choicePanel = new JPanel();
choicePanel.setBounds(250, 350, 300, 150);
choicePanel.setBackground(Color.black); /// reddi
choicePanel.setLayout(new GridLayout(4, 1)); /// 4 yatay 1 sütun
cont.add(choicePanel);

choice1 = new JButton();
choice1.setBackground(Color.black);
choice1.setForeground(Color.white);
choice1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
choice1.setFocusable(false);
choicePanel.add(choice1);
choice1.addActionListener(chs);
choice1.setActionCommand("ch1"); /// aga bu chs attık ya 4 fonksiyon oluduğunda hangis olduğunu seçecek

choice2 = new JButton();
choice2.setBackground(Color.black);
choice2.setForeground(Color.white);
choice2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
choice2.setFocusable(false);
choicePanel.add(choice2);
choice2.addActionListener(chs);
choice2.setActionCommand("ch2");

choice3 = new JButton();
choice3.setBackground(Color.black);
choice3.setForeground(Color.white);
choice3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
choice3.setFocusable(false);
choicePanel.add(choice3);
choice3.addActionListener(chs);
choice3.setActionCommand("ch3");

choice4 = new JButton();
choice4.setBackground(Color.black);
choice4.setForeground(Color.white);
choice4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
choice4.setFocusable(false);
choicePanel.add(choice4);
choice4.addActionListener(chs);
choice4.setActionCommand("ch4");

//// yan yana 4 tane oldu bunları alt alta atmak için

/// tepedeki hp barı
playerpanel = new JPanel();
playerpanel.setBounds(50, 15, 700, 50);
playerpanel.setBackground(Color.black);
playerpanel.setLayout(new GridLayout(1, 6));
cont.add(playerpanel);

hpJLabel = new JLabel("HP:");
hpJLabel.setForeground(Color.white);
hpJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
playerpanel.add(hpJLabel);

hpnumberJLabel = new JLabel();
hpnumberJLabel.setForeground(Color.white);
hpnumberJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
playerpanel.add(hpnumberJLabel);

moneybarJLabel = new JLabel("Money:");
moneybarJLabel.setForeground(Color.white);
moneybarJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
playerpanel.add(moneybarJLabel);

moneynumber = new JLabel();
moneynumber.setForeground(Color.white);
moneynumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
playerpanel.add(moneynumber);

weaponJLabel = new JLabel("WEAPON:");
weaponJLabel.setForeground(Color.white);
weaponJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
playerpanel.add(weaponJLabel);

weaponumberJLabel = new JLabel();
weaponumberJLabel.setForeground(Color.white);
weaponumberJLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
playerpanel.add(weaponumberJLabel);

playersetup();

}

public class tittlescreenhandler implements ActionListener {

@Override
public void actionPerformed(ActionEvent e) {

gamecreen();
}

}

public class chosehandler implements ActionListener {
////////7choicelrer tıklarsan seni atacağı yeri gösteriyor

@Override
public void actionPerformed(ActionEvent e) {

String chouse = e.getActionCommand();

switch (position) {
case "Town Gate":

switch (chouse) {
case "ch1":
if (silvering == 1) {
ending();
} else {

talkwizard();
}
break;
case "ch2":
AttacktheWizard();
break;
case "ch3":
crosroad();
break;
}
break;
case "Talkwizard":
switch (chouse) {
case "ch1":
talkinstage2();
break;
case "ch2":
towngate();
break;

}
break;
case "Talkwizard2":
switch (chouse) {
case "ch1":
talkinstage3();
;
break;
case "ch2":
towngate();
break;
case "ch3":
break;
case "ch4":
break;
}
break;
case "Talkwizard3":
switch (chouse) {
case "ch1":
talkinstage4();
;
break;
case "ch2":
towngate();
break;
case "ch3":
break;
case "ch4":
break;

}
break;

case "Talkwizard4":
switch (chouse) {
case "ch1":
talkinstage5();
break;
case "ch2":
crosroad();
break;
case "ch3":
break;
case "ch4":
break;

}
break;

case "Talkwizard5":
switch (chouse) {
case "ch1":
crosroad();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;

case "AttacktheWizard":
switch (chouse) {
case "ch1":
AttacktheWizard();
break;
case "ch2":
talkwizard();
break;
case "ch3":
towngate();
break;
case "ch4":
towngate();
break;
}
break;
case "crosroad":
switch (chouse) {
case "ch1":
north();
break;
case "ch2":
east();
break;
case "ch3":
towngate();
break;
case "ch4":
west();
break;
}
break;
case "north":
switch (chouse) {
case "ch1":
break;
case "ch2":
crosroad();
break;
case "ch3":
break;
case "ch4":
break;
}
break;
case "east":
switch (chouse) {
case "ch1":
crosroad();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;
}
break;
case "west":
switch (chouse) {

case "ch1":
playerattack();
break;
case "ch2":
crosroad();
break;
case "ch3":
break;
case "ch4":
break;
}
break;

case "playerattack":
switch (chouse) {
case "ch1":
if (vikinghp < 1) {
win();
} else {
monsterattack();
break;
}
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "monsterattack":
switch (chouse) {
case "ch1":
if (playerhp < 1) {
lose();
}

else {
playerattack();
}

case "ch2":
break;
case "ch3":
break;
case "ch4":
break;
}
case "win":
switch (chouse) {
case "ch1":
crosroad();
break;
case "ch2":
ilgilen();
break;
case "ch3":
break;
case "ch4":
break;
}
break;
case "ending":
switch (chouse) {

case "ch1":
talkinstage6();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;

case "Talkwizard6":
switch (chouse) {

case "ch1":
tuccar();
break;
case "ch2":
bar();
break;
case "ch3":
kalabalik();
break;
case "ch4":
break;

}
break;
case "bar":
switch (chouse) {

case "ch1":
rusvet();
break;
case "ch2":
if (money > 15) {
beeer();
} else {
papara();
}
break;
case "ch3":
minigame();
break;
case "ch4":
talkinstage6();
break;

}
break;
case "papara":
switch (chouse) {

case "ch1":
tuccar();
break;
case "ch2":
talkinstage6();
break;
case "ch3":
talkinstage6();
break;
case "ch4":
minigame();
break;

}
break;

case "minigame":
switch (chouse) {

case "ch1":
karo();
break;
case "ch2":
sinek();
break;
case "ch3":
talkinstage6();
break;
case "ch4":
break;

}
break;
case "tuccar":
switch (chouse) {

case "ch1":
sövalye();
break;
case "ch2":
excalibur();
break;
case "ch3":
dimitrescu();
break;
case "ch4":
talkinstage6();
;
break;

}
break;

case "ananmeydan":
switch (chouse) {

case "ch1":
tuccar();
break;
case "ch2":
bar();
break;
case "ch3":
kalabalik();
break;
case "ch4":
break;

}
break;

case "kalabalik":
switch (chouse) {

case "ch1":
kalabalik2();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "kalabalik2":
switch (chouse) {

case "ch1":
kalabalik3();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "kalabalik3":
switch (chouse) {

case "ch1":
kalabalik4();
break;

case "ch2":
talkinstage6();
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "kalabalik4":
switch (chouse) {

case "ch1":
tepeye();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "rusvet":
switch (chouse) {

case "ch1":
talkingstage7();
break;
case "ch2":
bar();
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "papara2":
switch (chouse) {

case "ch1":
talkinstage6();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;

case "girisekrani":
switch (chouse) {

case "ch1":
girisekrani2();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;

case "girisekrani2":
switch (chouse) {

case "ch1":
girisekrani3();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;

case "girisekrani3":
switch (chouse) {

case "ch1":
girisekrani4();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "girisekrani4":
switch (chouse) {

case "ch1":
towngate();
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;
case "tepeye":
switch (chouse) {

case "ch1":
tepeye2();                                                                    
break;
case "ch2":
break;
case "ch3":
break;
case "ch4":
break;

}
break;

}

}

}

public void playersetup() //// hp barı işte
{
vikinghp = 30;
wizardhp = 90;
playerhp = 15;
money = 10000;
weapon = "KNİFE";
weaponumberJLabel.setText(weapon);
hpnumberJLabel.setText("" + 15); /// aga bak int ama jabel sting çüzmzü "" +
moneynumber.setText(1000 + "$");
girisekrani();
/// towngate();

}

public void sövalye() {
if (money > 700) {
mainJTextArea.setText("Kesenize bereket efendim buyrun zırhınız");
playerhp += 60;
hpnumberJLabel.setText("" + playerhp);
money -= 700;
moneynumber.setText("" + money);

} else {
papara2();
}

}

public void excalibur() {

if (money >= 400) {
mainJTextArea.setText(
"Kesenize bereket efendim buyrun efsanelerde adı geçen excalibur kılıcınız\n\nEXCALİBURA HÜKMETTİNİZ ");
weapon = "excalibur";
weaponumberJLabel.setText("EXCALİBUR");
money -= 400;
moneynumber.setText("" + money);
} else {
papara2();
}
}

public void dimitrescu() {
if (money >= 1000) {
mainJTextArea.setText(
"Kesenize bereket efendim buyrun karanlıkların hükümdarı Lady Dimitrescunun  Dagger of Death Flowers hançeri\n dikkatli olunuz "
+ "aşırı derecede zehirlidir tek bir sıyrığı bile koca bir ejderi saniyelerde öldürebilir\n\nDagger of Death Flowersa sahipsiniz");
weapon = "Dagger of Death Flowers";
weaponumberJLabel.setText("Dagger of Death Flowers");
money -= 1000;
moneynumber.setText("" + money);

} else {
papara2();
}

}

public void sinek() {

Random rand = new Random();
int sayi = rand.nextInt(10) + 1;

String sonuc = "sinek";
if (sayi % 2 == 0) {
mainJTextArea.setText("tebrikler" + 50 + "$ kazandınız");
money += 50;
moneynumber.setText("" + money);
} else {
mainJTextArea.setText("tebrikler" + 20 + "$ kaybettiniz");
money -= 30;
moneynumber.setText("" + money);
}

}

public void karo() {
Random rand = new Random();
int sayi = rand.nextInt(10) + 1;

String sonuc = "karo";
if (sayi % 2 == 0) {
mainJTextArea.setText("tebrikler" + 50 + "$ kazandınız");
money += 50;
moneynumber.setText("" + money);
} else {
mainJTextArea.setText("tebrikler" + 20 + "$ kaybettiniz");
money -= 30;
moneynumber.setText("" + money);
}

}

public void towngate() {

position = "Town Gate";
mainJTextArea.setText("Kale surlarının önündesin \nŞövalye kapının önünde duruyor\n\nNe yapacaksın?");
mainJTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
choice1.setText("Şovalye ile konuş");
choice2.setText("Şovalyeye saldır ");
choice3.setText("ayrıl");
choice4.setText("<");
}

public void talkwizard() {
position = "Talkwizard";
mainJTextArea.setText(
"Knight:Merhaba yabancı\ndaha önce suratını görmemiştim.\nbitap halde görünüyorsun başına neler geldi böyle\nMono:Shiba köyünden buraya"
+ "ailem tarafından  gönderildim onlar için çok önemli birisiyle konuşmam lazım günlerdir yoldayım\nüzgünüm ama içeri girmene izin veremem\nMono:lütfen efendim hayatım buna bağlı");
choice1.setText(">");
choice2.setText("<");
choice3.setText("");
choice4.setText("");
}

public void talkinstage2() {
position = "Talkwizard2";
mainJTextArea
.setText("Knight:Katiyen olmaz Kralımıza suikast şüpheleri yüzünden seni asla içeri alamam uzak dur\nMono:lütfen efendim günlerdir yoldayım tüm köyümün hayatını buna bağlı"
+ "Şövalye:dediğmi duymadın mı evlat sana zarar vermeden önce burayı terk et rahatsız etme beni meşgulüm");
choice1.setText("ısrar et");
choice2.setText("terk et");
choice3.setText("");
choice4.setText("");
}

public void talkinstage3() {
position = "Talkwizard3";
mainJTextArea.setText(
"Mono:Efendim her şey buna bağlı ne isterseniz yaprım lütfen ne isterseniz\nŞövalye:....\nMONO:yalvarırım efendim\nŞövalye:aslında bir yolu var  bir yolu var ama riskli ve aramızda kalmalı\n"
+ "Mono:tabiki efendim ne derseniz o\nŞövalye:Eğer bu dediklerimi başka birisine dersen  başka bir yerde dedikodusu duyarsam senin derini yüzerim\nMONO:Söz veriyorum efendim kimseye bir şey demiyeceğim");
choice1.setText("kabul et");
choice2.setText("<");
choice3.setText("");
choice4.setText("");
}

public void talkinstage4() {
position = "Talkwizard4";
mainJTextArea.setText("Şövalte:Karım ve bir çoçuğum hasta ve kırmızı alarm verildiği için dışarı çıkamıyorum içerideki pazarda binlerce dolara satılan"
+ "şifalı bir bitki var bu maaşla yüzlerce yıl çalışsam alamam tek bir bölge de bulunuyor LANETLİ ORMANın Batı kısmında çıksam bile aşırı tehlikeli"
+ "yartıklarla dolu bir yer ordan bana bir tane HERMES OTU getirebilirsen mavi ve gümüş rengi karışımında "
+ "kendini belli eden bir bitki ormanda diğer bitkielreden ayırt edebilrisin ve bana getirirsen seni gizlice içeri sokabilirim gizli bir geçit biliyorum ");
choice1.setText("kabul et");
choice2.setText("<");
choice3.setText("");
choice4.setText("");
}

public void talkinstage5() {
position = "Talkwizard5";
mainJTextArea.setText("Knight:kabul ettin demek bol şans ihtiyacın olacak seni burada bekliyor olacağım");
choice1.setText("ayrıl");
choice2.setText("");
choice3.setText("");
choice4.setText("");
}

public void talkinstage6() {
position = "Talkwizard6";
mainJTextArea.setText(
"**ışık süzmesi suratına vuruyor kalabalık sesleri duyuluyor***\n\nhayvanlar etrafta koşuşturuyor\n\nşimdi ne yapacaksın?***\n");
choice1.setText("tüccara git");
choice2.setText("bara git");
choice3.setText("kalabalığa git");
choice4.setText("");
}

public void AttacktheWizard() {
position = "AttacktheWizard";
mainJTextArea.setText(
"Knight:Hey DON'T be a stupied!..\n*The knight fought back and hit you hard*\n(you recieve 3HP)");

playerhp = playerhp - 3;
hpnumberJLabel.setText("" + playerhp); //// stirng int mevzusu
choice1.setText("Attack the Knight");
choice2.setText("listen");
choice3.setText("<");
choice4.setText("<");
}

public void crosroad() {
position = "crosroad";
mainJTextArea.setText("Yol ayrımındasın nereye gideceksin?.\n\n Eğer güneye gidersen  kaleye geri döneceksin");

choice1.setText("go kuzet");
choice2.setText("go doğu");
choice3.setText("go güney");
choice4.setText("go batı");
}

public void north() {
position = "north";

mainJTextArea.setText(
"There is a riverThe nymph saw you\nsad and let you drink her holy water  from her river\n(HP recovery 2)\nmap is over pls go back ");
playerhp = playerhp + 2;
hpnumberJLabel.setText("" + playerhp);

choice1.setText("go east");
choice2.setText("go south");
choice3.setText("go west");
choice4.setText("");

}

public void east() {
position = "east";
mainJTextArea.setText(
"You waled into a forest..\n found a long Sword!!\nYOu obtained a long Sword)\nmap is over pls go back ");
weapon = "LONG SWORD";
weaponumberJLabel.setText(weapon);
choice1.setText("go north");
choice2.setText("go south");
choice3.setText("go west");
choice4.setText("");

}

public void west() {

position = "west";
mainJTextArea.setText("Bir büyücüyle karşılasştın .Ne yapacaksın??\nBüyücü:" + vikinghp + "HP");

choice1.setText("Dövüş");
choice2.setText("kaç");
choice3.setText("");
choice4.setText("");
}

public void playerattack() {

position = "playerattack";

int playerdamage = 0;
if (weapon.equals("KNİFE")) {
playerdamage = new java.util.Random().nextInt(5); // 0-5 attack veriyor

}

if (weapon.equals("LONG SWORD")) {
playerdamage = new java.util.Random().nextInt(15); // 0-5 attack veriyor

}

vikinghp = vikinghp - playerdamage;
mainJTextArea.setText(
"Viking:Hur vågar du gå in på mitt territorium, för Odens skulldu är död nu\\n(How dare you enter my territory,\\nfor Odin's sake, you are dead now.\n\nYou attacked the viking\nGave "
+ playerdamage + " Damage!\nvikinghp:" + vikinghp);
choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}

public void monsterattack() {
position = "monsterattack";
int attack = 0;
attack = new java.util.Random().nextInt(5);
mainJTextArea.setText("Büyücü sana saldırdı \nSana  " + attack
+ " Hasar verdi \nuzaklaştıram büyüsüyle seni yol dışına fırlattı");
playerhp = playerhp - attack;
if (vikinghp < 0) {
win();
}
hpnumberJLabel.setText("" + playerhp);
choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}

public void win() {
position = "win";
mainJTextArea.setText(
"You defeated the monster!\nThe monster dropped a ring!\n\n(Your obtained a silver Ring\n\nağlama sesi duydun)");
;
silvering = 1;
choice1.setText("geri dön ");
choice2.setText("ilgilen");
choice3.setText("");
choice4.setText("");
}

public void lose() {
position = "lose";

hpnumberJLabel.setText("DEAD!!");
choice1.setText("");
choice2.setText("");
choice3.setText("");
choice4.setText("");
choice1.setVisible(false);
choice2.setVisible(false);
choice3.setVisible(false);
choice4.setVisible(false);
}

public void ending()

{
position = "ending";

mainJTextArea.setText(
"Knight:Oh you back did you killed that witch really???\ngöründüğünden çok daha güçlüymüşssün ama içeride dikkatli ol dışarısdann daha tehlikeli\n\nMono:istedğin bitki\n**bitkiyi verir**\nK"
+ "night sözüm söz merak etme beni takip et\n**karanlık geçitten geçilir**\n**kalenin içindesin**");
choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}

///////////// girdkiten sonra

public void ananmeydan() {

position = "anameydan";
mainJTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 17));
mainJTextArea.setText("meydandasın ne yapacaksın");
choice1.setText("tüccara git");
choice2.setText("bara git");
choice3.setText("kalabalığın oraya doğru git");
choice4.setText("");

}

public void bar() {
position = "bar";
mainJTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 17));
mainJTextArea.setText(
"*bara giriş yaptın**müzik çalıyor kalabalık sesler her yerde*\n\nBarmen:ne istersiniz buralarda yenisiniz galiba\n\nMono:herkes değil mi zaten\nBarmen:evet haklısınız"
+ "burası büyük bir kale herkesi tanıyamazsınız\n\nMono:1 bira|\n\nBarmen tabi efendim\n*birayı verir*");
choice1.setText("büyücüyle ilgili soru sor");
choice2.setText("bir bira daha");
choice3.setText("Black Jack");
choice4.setText("bardan çıkış");
}

public void tuccar() {
position = "tuccar";
mainJTextArea.setText("Buyrun efendim hoşgeldiniz ne istersiniz\n\n" + "deri zırh:   200$     +25can\n"
+ "excalibur:   300$     30-45 hasar\nDagger of Death Flowers:   1000$     70-100 hasar\n"
+ "şovalte zırhı:700$ +60can");
choice1.setText("şovalte zırhı");
choice2.setText("excalibur");
choice3.setText("Dagger of Death Flowers ");
choice4.setText("<");
}

public void beeer() {

mainJTextArea.setText("buyrun efendim içkiniz");
money = money - 15;
moneynumber.setText(money + "");
if (money < 15) {
papara();
}

}

public void ilgilen() {
mainJTextArea.setText(
"Mono:KİM VAR ORDA\nçocuk:lütfen beni öldürme\nMono:Sakin ol sende kimsin\nÇocuk:ben az önce dövüştüğün büyücünün yardımcısıyımı\n aslındna iyi biri ben evsiz yetimdi"
+ "bana baktı yadım etti yetşitir weow ");

}

public void papara() {
position = "papara";
mainJTextArea.setText("YETERSİZ BAKİYE");
choice1.setText("kralla ilgili soru sor");
choice2.setText("sohbet");
choice3.setText("bardan çıkış");
choice4.setText("");

}

public void papara2() {
position = "papara2";
mainJTextArea.setText("YETERSİZ BAKİYE");
choice1.setText("ayrıl");
choice2.setText("");
choice3.setText("");
choice4.setText("");
}

public void minigame() {

position = "minigame";
if (money < 20) {

papara();

}

else {

mainJTextArea.setText("giriş ücreti:20 dolar\n\n kart seçiniz\n\n");
money -= 20;
moneynumber.setText("" + money);

Random rand = new Random();
int sayi = rand.nextInt(10) + 1;

String sonuc = "karo";
if (sayi % 2 == 0) {
String karo;
} else {
String sinek;
}

choice1.setText("karo");
choice2.setText("sinek");
choice3.setText("ayrıl");
choice4.setText("");

}

}

public void kalabalik() {
position = "kalabalik";
mainJTextArea.setText(
"kalabalığa doğru yöneldin bir idama şahit oldun kalabalık öfkeli hep bir agızdan İDAM İDAM sesli yükseliyordu"
+ "idam sephasında uzun beyaz sakallı sol gözü olmayan sert bakışlı bir adam vardı dik duruşundan hiç ödün vermiyordu"
+ "başında bekleyen adam konuşmaya başladı\n-efendiler bildiğniz gibi önümde duran alçak");

choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}

public void kalabalik2() {
position = "kalabalik2";
mainJTextArea.setText(
"ve ardından idam edilecek bir sürü hain krallığımıza zarar verip çökertmeye çalışıp kendilerine devrim kulübü diyen bir avuç soytarılar bugün hepsinin sonu gelecek yılanın başının kesilemesinin zamanı geldi\n CELLAT:var mıdır son sözün");

choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}

public void kalabalik3() {
position = "kalabalik3";
mainJTextArea.setText(
"Devrim lideri başkanı:korkmayın halkım ben öldüm diye bu devrim bitecek değil daha her şey yeni başlıyor çok yakında devrim başlıyor"
+ "sizden istedğim tek şey korkmayınız her şey sizin hakkınız sıkı durup birbirinizi kenetlenin\n\nidam sehpsası devrilir..");

choice1.setText("birisiyle konuş");
choice2.setText("ayrıl");
choice3.setText("");
choice4.setText("");

}

public void kalabalik4() {
position = "kalabalik4";
mainJTextArea.setText(
"affedersinizi bunlarda kim?\nYabancı:burlarda yeni misin? her neyse kralı devirmeye çalışan bir grup devrimci kendilierine ASRIN MUHAFIZLARI diyorlar");
choice1.setText("ayrıl");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}

public void rusvet() {
position = "rusvet";
mainJTextArea.setText("Barmen:bir şifacı mı o şarlatanlardan her yerde var ama saklanıyorlar eğer biri yakalanrısa enginazsyon onları ip gibi sallandırı hahaha"
+ "Mono:sunsho diye birisini tanıyor musun"
+ "Barmen:hayır "
+ "Mono:peki nerde bulabileceğim hakkında bir bilgin var mı?"
+ "Barmen:var ama bedavaya söylemem");
choice1.setText("40$ rüşvet ver");
choice2.setText("ayrıl");
choice3.setText("");
choice4.setText("");
}

public void talkingstage7()

{
if (money < 100) {
position = "kalabalık4";
mainJTextArea.setText(
"Mono:üzgünüm o kadar param yok\nBarmen:uzak dur burdan seni şikayet etmediğim için şanslısın");
choice1.setText("ayrıl");
choice2.setText("");
choice3.setText("");
choice4.setText("");
}

else {
position = "kalabalik4";
money -= 100;
moneynumber.setText("" + money);
mainJTextArea.setText("40 papel ha bak bu çalışır büyücü arıyorsan bir duyum almıştım  buranın kuzeyinde yüksek tepelerin ordaki mezarlığın orda yaşayan,"
+ "bir büyücü duymuştum ordaki cesetlerle deney yapılıdğı dedikodusu yayılmış bir çocuk görmüş ama dikkatli ol seni "
+ "bir kurabağaya çevirmesin hahaha\n"
+ "Mono:bilgi için teşekkürler\n"
+ "Barmen:dikkatli ol evlat orlar biraz tehlikieli yerler başı boş hyavanlar ve evsizler var");
choice1.setText("oraya git");
choice2.setText("");
choice3.setText("");
choice4.setText("");
}

}

public void girisekrani()

{


position = "girisekrani";

mainJTextArea.setText("Asırlar öncesine dayanaan bir hikaye dillerden dile dolanan Mononun öyküsü"
+ "SHİBA köyünün ücra bir kasabısnda bir lanet ayılmıştı ekinler soluyor daha doğmadan çocuklar ölüyordu doğanlarda sakat"
+ "doğuyorlardı halk tedirgindi her akşam evlerini önlerinden uğultular silüeyler geçtiğini söylüyordu köylüler bu durumu daha fazla kadlıramz oldu"
+ "kadınların çoğu doğumda ölüyrdu kalan çocuklar yetersiz beslenemden erkek ise inthar ediyordu"
+ "bu duruma dayanamayan halk bölge büyücüüsne gider büyücü üzerinizde çok büyük bir lanet olduğundan bahseder kendis seviyesini bile aşan bir lanet"
+ "bozabilecek tek bir kişi vardır ve bu kişi kalede yaşıyordur kimliğni gizli tutuyorudur onun bulunması lazımm küçük yaşta babası kaybeden mono"
+ "annesi ve kız kardeşiyle beraber kıt kanaat geçiniyorlardı annesi terziydi kendisi de küçük yaşta hayvanlara bakıyordu"
+ "kız kardeşi de annesine yardım ediyordu eve yardım ediyordu "
+ "ama kardeşi iblisler yüzünden komaya girdi mono bu bu büyüyü kırmak için şehre gidecekti  annesiyle ve kız kardeşiyle sonkez sarıldı ve öptü"
+ "kıtlık olduğu için ve lehre sağ salim gidebileceğinin garantisi olmadığı için çok az bir erzak aldı"
+ "annesi çıkmadan önce ona bir parşömen bir kolye  ve bir kılıç verdi bu\n"
+ "");
choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");




}
















public void girisekrani2()

{


position = "girisekrani2";

mainJTextArea.setText("Anne:bize babandan kalan bir kılıç\nMono:ama babam bir çiftçiydi bu böyle bir kılıç ne arıyor\nAnne:ailenle ilgili daha öğrenmen gereken çok şey var zamanı gelince açıklayacaktım ama böyle olacağını hiç tahmin edemezdim parşömeni "
+ "büyücüye verirsin normal şartlarda seni asla kabul etmez oraya gidene kadar açma sağsalim gideceğine eminim oğlum\n"
+ "kadının gözünen yaşlar süzülür ve oğlunu yolcu eder"
+ "yola koyulur ve macera ya atılır engebeli patikalardan vadilerden  geçer ve akşam olur ruhlar tarafında rahatsız edilir her zaman"
+ "arkadan onu ölüdmrek işkence etmek ile ilgili sözler gelir her fırsatta onu korkutur vazgeçirirler "
+ "akıl sağlığını yitirme derecesine gelir günler boyunca uyuyamaz en sonunda küçük bir kasaba görür ama laneti oraya da bulaştırmaktan korktuğu için ordan uak duru en "
+ "sonunda yorgunluktan bitap oldu ve bayıldı ertesi güün uyadnığında başında bir kadın ve kızı vardı bir at arabsında hareket halindelerdi\n"
+ "Mono:nerdeyim ben sizde kimsiniz\n");

choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");



}

public void girisekrani3()

{


position = "girisekrani3";

mainJTextArea.setText("Kadın:bizler şehre giden tüccarlarız yolda seni bayılmış perişan halde gördük kocam ve benim seni böyle bir halde halde bırakmakaya vicdanımız el vermedi\nMono tedirgindi kedni başına gelenlerin onlarında başına gelmesinden korkuyordu ama perişan haldeydi belki de gereksiz kuruntu yapıyordur belkidelanet peşini bırakmıştır"
+ "Kadın:evladım bu yaşta burlarda ne arıyorsun annen baban nerde nereye gidiyorsun\n"
+ "Mono:ailem beni bir iş için CANTRA şehrindeki kaleye gönderdi köyümüzde büyük felaketler oluyor\n"
+ "Kadın:zavallı çocuk zor dönemlerden geçiyoruz biz de o şehre uğrayacağız bir takım işlerimiz var seni oraya sağ sağlim ulaştırız merak etme sen dinelneme bak n baya bi harap olmuşşun zaten zavallı çocuk\n mono uzun zaman sonra dinleniyordu ama  onu  içten içe kemiren kötü bir hissi vardı ama yorgunluktan onu düşünemiyordu ve uyuya kaldı\n"
+ "at arabası birden devrildi mono sersemlemişti çığlık sesleri havada yankılanıyordu hemen yanındanki kılıcı alıp  dışarıd çıktı gördüğü manzara karşısında şok oldu"

+ "");


choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");



}


public void girisekrani4()

{


position = "girisekrani4";

mainJTextArea.setText(""
+ "küçük kız babasını canice öldürmüştü suratına onlarca defa bıçak salllamıştı ve annesine de aynısını yapmak  köşeye sıkıştırmıştı annesi çığlık atıp yardım istiyordu"
+ "mono olan bitenin farkına vardı ruhlar bu aileyi de mahvediyordu buna dayanamıyordu kılıcını çekip kızın arkasından kalbine doğru kılıcını sapladı içinden kara ruh çıktı ve"
+ "etraftan gülme sesleri geliyordu ruhlar ona ve kadına gülüyorlardı kadın kıznın gözünğün önünde öldüğünü görünce daha da ağlamaya başladı delirimişcesine ağlamaya başladı mono "
+ "yardım etmek için yanına doğru gitti zavallı kadın zavallı adam zavallı kız sadece bana yardım etmek isitoyrlardı neye yol açtım kadına yaklaştı iyi  misiniz kadın kahkaa atmaya başladı 'kendin için endişelenme"
+ "lisin'diyip üstüne saldırdı mono onun da ruhlar tarafından ele geçirilidğini anladı yapablieceği bir şey yoktu kılıcını karnına doğru geçirdi cesedi üstüne düştü mono ağlıyordu neden bunların kendi başına geldiğini düşünüyordu"
+ "güneş doğmaya başlamıştı ruhlar kayboluyordu mono kalktı etrafına baktı atlar kaçmıştı ama yolu az kalmıştı cesetleri bir araya toplayıp yaktı ve at arabasından biraz yiyecek alıp yoluna devam etti ufukta kale görünüyordu\\n");


choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");



}




public void tepeye() {
position = "tepeye";
mainJTextArea.setText("mono bardan ayrılıp tepeye doğru yola koyulur ıssız sokakları geçer birkaç kez köpek saldırsından kurtulur en sonundan bahsedilen"
+ "mezarlığın oraya gider etrafta hiç insan yoktu"
+ "etrafta geziniyordu her akşam sökmek üzereydi yine ruhların gelmesinden endişeliydi her tarafta yıkık evler vardı köşede bankta oturan yaşlı bir adam gördü"
+ "yanına doğru gitti yaşlı adam pipposunun tüttürüyordu mono yanına yaklaştı\n"
+ "Mono:merhaba efendim ben shiba köyünden geliyorum birisini arıyordum\n"
+ "Adam:kimi arıyordun evladım buralarda yeni misin buralara uğrayan pek olmaz ismin ne?\n"
+ "Mono:Mono Yamaguchi shibua köyünden geliyorum bir büyücü arıyorum Kōgyoku isimli daha önce duydun mu\n"
+ "adam şaşırır pippsonun ağzından düşürür\n"

+ "Adam:Yamaguchi kolunda dövme var mı?¨\n"
+ "");
choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}
public void tepeye2() {
mainJTextArea.setText("çocuk kolundaki üçgen içindeki kitap ve kılıç dövmesini gösterir\n"
+ "inanamıyorum buralarda ne arıyorsun diyip çocuga sarılır 'kim yaptı bu dövmeyi sana'\n"
+ "Mono:babam ben küçükken yapmış dövmem olduğunun nerden biliyorsun?\n"
+ "Adam:hava kararmak üzere gel bugün misafirimsin aradığın kişi benim yıllar sonra torunuyla la buluşmak ha ne büyük şans\n"
+ "ikisi birlikte eve girer "
+ "");
position = "tepeye2";
choice1.setText(">");
choice2.setText("");
choice3.setText("");
choice4.setText("");

}






}
