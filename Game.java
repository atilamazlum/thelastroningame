import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game {
    // Window
    JFrame window;
    BackgroundPanel bgPanel;

    // UI Components
    TypewriterTextArea mainText;
    StyledButton[] choices = new StyledButton[4];
    HPBar hpBar;
    JLabel moneyLabel, weaponLabel, titleLabel;
    JPanel topBar, textPanel, choicePanel, titlePanel, startPanel;
    StyledButton startButton;

    // Game state
    PlayerState player = new PlayerState();
    String position;
    Random rand = new Random();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }

    public Game() {
        // --- Window setup ---
        window = new JFrame("ADVENTURE GAME — Mono'nun Öyküsü");
        window.setSize(850, 650);
        window.setMinimumSize(new Dimension(750, 550));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        bgPanel = new BackgroundPanel();
        bgPanel.setLayout(new BorderLayout());
        window.setContentPane(bgPanel);

        showTitleScreen();
        window.setVisible(true);
    }


    private void showTitleScreen() {
        bgPanel.removeAll();
        bgPanel.setTheme(BackgroundPanel.THEME_DARK);

        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setOpaque(false);
        center.setBorder(BorderFactory.createEmptyBorder(50, 50, 25, 50));

        // Title
        titleLabel = new JLabel("THE LAST RONIN");
        titleLabel.setForeground(new Color(220, 200, 170));
        titleLabel.setFont(new Font("Serif", Font.BOLD, 52));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(titleLabel);

        center.add(Box.createVerticalStrut(5));

        center.add(Box.createVerticalStrut(30));

        // Sword
        JLabel sword = new JLabel("▬▬▬▬ι════════════ﺤ");
        sword.setForeground(new Color(139, 115, 85));
        sword.setFont(new Font("Serif", Font.PLAIN, 36));
        sword.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(sword);

        center.add(Box.createVerticalStrut(5));



        center.add(Box.createVerticalStrut(100));

        // Menu buttons
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setOpaque(false);

        // Maceraya Basla
        StyledButton btnStart = new StyledButton("Maceraya Başla");
        btnStart.setFont(new Font("Serif", Font.BOLD, 22));
        btnStart.setMaximumSize(new Dimension(320, 50));
        btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStart.addActionListener(e -> startGame());
        menuPanel.add(btnStart);
        menuPanel.add(Box.createVerticalStrut(40));


        // Yapimcilar
        StyledButton btnCredits = new StyledButton("Yapımcılar");
        btnCredits.setFont(new Font("Serif", Font.BOLD, 20));
        btnCredits.setMaximumSize(new Dimension(320, 60));
        btnCredits.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCredits.addActionListener(e -> showCredits());
        menuPanel.add(btnCredits);
        menuPanel.add(Box.createVerticalStrut(40));



        // Cikis
        StyledButton btnQuit = new StyledButton("Çıkış");
        btnQuit.setFont(new Font("Serif", Font.BOLD, 20));
        btnQuit.setMaximumSize(new Dimension(320, 45));
        btnQuit.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnQuit.addActionListener(e -> System.exit(0));
        menuPanel.add(btnQuit);

        center.add(menuPanel);

        center.add(Box.createVerticalGlue());

        JLabel version = new JLabel("v2.0");
        version.setForeground(new Color(80, 70, 55));
        version.setFont(new Font("Serif", Font.PLAIN, 11));
        version.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(version);

        bgPanel.add(center, BorderLayout.CENTER);
        bgPanel.revalidate();
        bgPanel.repaint();
    }

    // ==================== MENU SCREENS ====================
    // BUNLARI showTitleScreen()'in HEMEN ALTINA EKLE




    private void showCredits() {
        bgPanel.removeAll();
        bgPanel.setTheme(BackgroundPanel.THEME_TOWN);
        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.setOpaque(false);
        c.setBorder(BorderFactory.createEmptyBorder(50, 60, 25, 60));

        JLabel t = new JLabel("Yapımcılar");
        t.setForeground(new Color(220, 200, 170));
        t.setFont(new Font("Serif", Font.BOLD, 32));
        t.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(t);
        c.add(Box.createVerticalStrut(40));

        JLabel l3 = new JLabel("Hikaye & Senaryo", SwingConstants.CENTER);
        l3.setForeground(new Color(139, 115, 85));
        l3.setFont(new Font("Serif", Font.BOLD, 14));
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l3);
        c.add(Box.createVerticalStrut(20));
        JLabel l4 = new JLabel("— MAZLUM ATİLA —", SwingConstants.CENTER);
        l4.setForeground(new Color(180, 160, 130));
        l4.setFont(new Font("Serif", Font.ITALIC, 16));
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l4);
        c.add(Box.createVerticalStrut(20));
        JLabel l5 = new JLabel("Görsel Sanatlar & Arayüz", SwingConstants.CENTER);
        l5.setForeground(new Color(139, 115, 85));
        l5.setFont(new Font("Serif", Font.BOLD, 14));
        l5.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l5);
        c.add(Box.createVerticalStrut(20));
        JLabel l6 = new JLabel("— MAZLUM ATİLA —", SwingConstants.CENTER);
        l6.setForeground(new Color(180, 160, 130));
        l6.setFont(new Font("Serif", Font.ITALIC, 16));
        l6.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l6);
        c.add(Box.createVerticalStrut(20));
        JLabel l7 = new JLabel("Müzik & Ses Efektleri", SwingConstants.CENTER);
        l7.setForeground(new Color(139, 115, 85));
        l7.setFont(new Font("Serif", Font.BOLD, 14));
        l7.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l7);
        c.add(Box.createVerticalStrut(20));
        JLabel l8 = new JLabel("— MAZLUM ATİLA —", SwingConstants.CENTER);
        l8.setForeground(new Color(180, 160, 130));
        l8.setFont(new Font("Serif", Font.ITALIC, 16));
        l8.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l8);
        c.add(Box.createVerticalStrut(20));
        JLabel l9 = new JLabel("Kalite Kontrol & Test", SwingConstants.CENTER);
        l9.setForeground(new Color(139, 115, 85));
        l9.setFont(new Font("Serif", Font.BOLD, 14));
        l9.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l9);
        c.add(Box.createVerticalStrut(20));
        JLabel l10 = new JLabel("— MAZLUM ATİLA —", SwingConstants.CENTER);
        l10.setForeground(new Color(180, 160, 130));
        l10.setFont(new Font("Serif", Font.ITALIC, 16));
        l10.setAlignmentX(Component.CENTER_ALIGNMENT);
        c.add(l10);

        c.add(Box.createVerticalStrut(35));

        StyledButton back = new StyledButton("← Ana Menü");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(e -> showTitleScreen());
        c.add(back);

        bgPanel.add(c, BorderLayout.CENTER);
        bgPanel.revalidate(); bgPanel.repaint();
    }



    // ==================== GAME SCREEN SETUP ====================
    private void startGame() {
        bgPanel.removeAll();
        player.reset();

        // --- Top bar ---
        topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 5));
        topBar.setOpaque(false);
        topBar.setBorder(BorderFactory.createEmptyBorder(8, 15, 5, 15));

        // HP section
        JLabel hpLabel = makeLabel("HP:", 16);
        topBar.add(hpLabel);
        hpBar = new HPBar(15);
        hpBar.setHp(player.hp);
        topBar.add(hpBar);

        topBar.add(Box.createHorizontalStrut(20));

        // Money section
        JLabel moneyTitle = makeLabel("Para:", 16);
        topBar.add(moneyTitle);
        moneyLabel = makeLabel(player.money + "$", 16);
        topBar.add(moneyLabel);

        topBar.add(Box.createHorizontalStrut(20));

        // Weapon section
        JLabel weaponTitle = makeLabel("Silah:", 16);
        topBar.add(weaponTitle);
        weaponLabel = makeLabel(player.weapon, 16);
        topBar.add(weaponLabel);

        // Separator line under top bar
        JPanel topWrapper = new JPanel(new BorderLayout());
        topWrapper.setOpaque(false);
        topWrapper.add(topBar, BorderLayout.CENTER);
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(80, 60, 40));
        topWrapper.add(sep, BorderLayout.SOUTH);

        bgPanel.add(topWrapper, BorderLayout.NORTH);

        // --- Center text ---
        textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false);
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 10, 60));

        mainText = new TypewriterTextArea();
        JScrollPane scroll = new JScrollPane(mainText);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUI(new DarkScrollBarUI());

        textPanel.add(scroll, BorderLayout.CENTER);
        bgPanel.add(textPanel, BorderLayout.CENTER);

        // --- Choice buttons ---
        choicePanel = new JPanel();
        choicePanel.setLayout(new GridLayout(2, 2, 10, 8));
        choicePanel.setOpaque(false);
        choicePanel.setBorder(BorderFactory.createEmptyBorder(10, 100, 25, 100));

        for (int i = 0; i < 4; i++) {
            choices[i] = new StyledButton("");
            final int idx = i;
            choices[i].addActionListener(e -> handleChoice("ch" + (idx + 1)));
            choicePanel.add(choices[i]);
        }

        bgPanel.add(choicePanel, BorderLayout.SOUTH);

        bgPanel.revalidate();
        bgPanel.repaint();

        girisekrani();
    }

    // ==================== UI HELPERS ====================
    private JLabel makeLabel(String text, int size) {
        JLabel l = new JLabel(text);
        l.setForeground(new Color(220, 200, 170));
        l.setFont(new Font("Serif", Font.BOLD, size));
        return l;
    }

    private void setScene(String pos, String text, int theme, String c1, String c2, String c3, String c4) {
        position = pos;
        bgPanel.setTheme(theme);
        mainText.setTypewriterText(text);
        choices[0].setText(c1);
        choices[1].setText(c2);
        choices[2].setText(c3);
        choices[3].setText(c4);
        // Show/hide buttons based on text
        for (int i = 0; i < 4; i++) {
            choices[i].setVisible(!choices[i].getText().isEmpty());
        }
    }

    private void updateHUD() {
        if (hpBar != null) {
            hpBar.setMaxHp(Math.max(15, player.hp + 10)); // dynamic max
            hpBar.setHp(player.hp);
        }
        if (moneyLabel != null) moneyLabel.setText(player.money + "$");
        if (weaponLabel != null) weaponLabel.setText(player.weapon);
    }

    // ==================== CHOICE HANDLER ====================
    private void handleChoice(String ch) {
        mainText.skipAnimation(); // skip if still animating

        switch (position) {
            case "girisekrani":
                if ("ch1".equals(ch)) girisekrani2();

                break;
            case "girisekrani2":
                if ("ch1".equals(ch)) girisekrani3();
                break;
            case "girisekrani3":
                if ("ch1".equals(ch)) girisekrani4();
                break;
            case "girisekrani4":
                if ("ch1".equals(ch)) towngate();
                break;
            case "Town Gate":
                switch (ch) {
                    case "ch1":
                        if (player.hasSilverRing) ending();
                        else talkwizard();
                        break;
                    case "ch2": attackKnight(); break;
                    case "ch3": crossroad(); break;
                }
                break;
            case "Talkwizard":


                switch (ch) {
                    case "ch1": talkinstage2(); break;
                    case "ch2": towngate(); break;
                }
                break;
            case "Talkwizard2":
                switch (ch) {
                    case "ch1": talkinstage3(); break;
                    case "ch2": towngate(); break;
                }
                break;
            case "Talkwizard3":
                switch (ch) {
                    case "ch1": talkinstage4(); break;
                    case "ch2": towngate(); break;
                }
                break;
            case "Talkwizard4":
                switch (ch) {
                    case "ch1": talkinstage5(); break;
                    case "ch2": crossroad(); break;
                }
                break;
            case "Talkwizard5":
                if ("ch1".equals(ch)) crossroad();
                break;
            case "AttackKnight":
                switch (ch) {
                    case "ch1": attackKnight(); break;
                    case "ch2": talkwizard(); break;
                    case "ch3": case "ch4": towngate(); break;
                }
                break;
            case "crossroad":
                switch (ch) {
                    case "ch1": north(); break;
                    case "ch2": east(); break;
                    case "ch3": towngate(); break;
                    case "ch4": west(); break;
                }
                break;
            case "north":
                if ("ch2".equals(ch)) crossroad();
                break;
            case "east":
                if ("ch1".equals(ch)) crossroad();
                break;
            case "west":
                switch (ch) {
                    case "ch1": playerAttack(); break;
                    case "ch2": crossroad(); break;
                }
                break;
            case "playerattack":
                if ("ch1".equals(ch)) {
                    if (player.vikingHp < 1) win();
                    else monsterAttack();
                }
                break;
            case "monsterattack":
                if ("ch1".equals(ch)) {
                    if (player.hp < 1) lose();
                    else playerAttack();
                }
                break;
            case "win":
                switch (ch) {
                    case "ch1": crossroad(); break;
                    case "ch2": ilgilen(); break;
                }
                break;
            case "ending":
                if ("ch1".equals(ch)) talkinstage6();
                break;
            case "Talkwizard6":
                switch (ch) {
                    case "ch1": tuccar(); break;
                    case "ch2": bar(); break;
                    case "ch3": kalabalik(); break;
                }
                break;
            case "bar":
                switch (ch) {
                    case "ch1": rusvet(); break;
                    case "ch2": if (player.money > 15) beeer(); else papara(); break;
                    case "ch3": minigame(); break;
                    case "ch4": talkinstage6(); break;
                }
                break;
            case "papara":
                switch (ch) {
                    case "ch1": tuccar(); break;
                    case "ch2": case "ch3": talkinstage6(); break;
                    case "ch4": minigame(); break;
                }
                break;
            case "minigame":
                switch (ch) {
                    case "ch1": karo(); break;
                    case "ch2": sinek(); break;
                    case "ch3": talkinstage6(); break;
                }
                break;
            case "tuccar":
                switch (ch) {
                    case "ch1": sovalyeZirhi(); break;
                    case "ch2": excalibur(); break;
                    case "ch3": dimitrescu(); break;
                    case "ch4": talkinstage6(); break;
                }
                break;
            case "kalabalik":
                if ("ch1".equals(ch)) kalabalik2();
                break;
            case "kalabalik2":
                if ("ch1".equals(ch)) kalabalik3();
                break;
            case "kalabalik3":
                switch (ch) {
                    case "ch1": kalabalik4(); break;
                    case "ch2": talkinstage6(); break;
                }
                break;
            case "kalabalik4":
                if ("ch1".equals(ch)) tepeye();
                break;
            case "rusvet":
                switch (ch) {
                    case "ch1": talkingstage7(); break;
                    case "ch2": bar(); break;
                }
                break;
            case "papara2":
                if ("ch1".equals(ch)) talkinstage6();
                break;
            case "tepeye":
                if ("ch1".equals(ch)) tepeye2();
                break;
            case "tepeye2":
                // devam edecek...
                break;
        }
    }

    // ==================== SCENES ====================

    // --- INTRO ---
    void girisekrani() {




        // kendi resmini ekle
        ImageIcon img = new ImageIcon("images/castle.jpg");
        Image scaled = img.getImage().getScaledInstance(700, 180, Image.SCALE_SMOOTH);
        JLabel resimLabel = new JLabel(new ImageIcon(scaled));


        setScene("girisekrani",
            "Asırlar öncesine dayanan bir hikaye... Dillerden dile dolanan Mono'nun öyküsü.\n\n" +
            "Shiba köyünün ücra bir kasabasında bir lanet yayılmıştı. Ekinler soluyor, daha doğmadan çocuklar " +
            "ölüyordu. Doğanlar da sakat doğuyorlardı. Halk tedirgindi — her akşam evlerinin önünden uğultular, " +
            "silüetler geçtiğini söylüyorlardı.\n\n" +
            "Köylüler bu durumu daha fazla kaldıramaz oldu. Kadınların çoğu doğumda ölüyordu, kalan çocuklar " +
            "yetersiz besleniyordu, erkekler intihar ediyordu.\n\n" +
            "Bu duruma dayanamayan halk bölge büyücüsüne gider. Büyücü, üzerlerinde çok büyük bir lanet " +
            "olduğundan bahseder — kendi seviyesini bile aşan bir lanet. Bozabilecek tek bir kişi vardır ve " +
            "bu kişi kalede yaşıyordur, kimliğini gizli tutuyordur.\n\n" +
            "Küçük yaşta babasını kaybeden Mono, annesi ve kız kardeşiyle beraber kıt kanaat geçiniyordu. " +
            "Ama kardeşi iblisler yüzünden komaya girdi. Mono bu büyüyü kırmak için şehre gidecekti...\n\n" +
            "Annesiyle ve kız kardeşiyle son kez sarıldı ve öptü.",
            BackgroundPanel.THEME_DARK, "▸", "", "", "");
    }

    void girisekrani2() {
        setScene("girisekrani2",
            "Anne: Bize babandan kalan bir kılıç.\n" +
            "Mono: Ama babam bir çiftçiydi, böyle bir kılıç ne arıyor?\n" +
            "Anne: Ailenle ilgili daha öğrenmen gereken çok şey var. Zamanı gelince açıklayacaktım ama " +
            "böyle olacağını hiç tahmin edemezdim. Parşömeni büyücüye verirsin, normal şartlarda seni " +
            "asla kabul etmez. Oraya gidene kadar açma.\n\n" +
            "Kadının gözünden yaşlar süzülür ve oğlunu yolcu eder.\n\n" +
            "Yola koyulur ve maceraya atılır. Engebeli patikalardan, vadilerden geçer... Akşam olur. " +
            "Ruhlar tarafından rahatsız edilir — her zaman arkadan onu öldürmek, işkence etmekle ilgili " +
            "sözler gelir. Her fırsatta onu korkuturlar.\n\n" +
            "Akıl sağlığını yitirme derecesine gelir. Günler boyunca uyuyamaz. En sonunda küçük bir " +
            "kasaba görür ama laneti oraya da bulaştırmaktan korktuğu için uzak durur.\n\n" +
            "Yorgunluktan bitap oldu ve bayıldı. Ertesi gün uyandığında başında bir kadın ve kızı vardı, " +
            "bir at arabasında hareket halindeydiler.\n\n" +
            "Mono: Nerdeyim ben? Siz de kimsiniz?",
            BackgroundPanel.THEME_DARK, "▸", "", "", "");
    }

    void girisekrani3() {
        setScene("girisekrani3",
            "Kadın: Bizler şehre giden tüccarlarız. Yolda seni bayılmış, perişan halde gördük. " +
            "Kocam ve benim seni böyle bir halde bırakmaya vicdanımız el vermedi.\n\n" +
            "Mono tedirgindi. Kendi başına gelenlerin onların da başına gelmesinden korkuyordu.\n\n" +
            "Kadın: Evladım, bu yaşta buralarda ne arıyorsun? Annen baban nerede?\n" +
            "Mono: Ailem beni bir iş için Cantra şehrindeki kaleye gönderdi. Köyümüzde büyük felaketler oluyor.\n" +
            "Kadın: Zavallı çocuk... Zor dönemlerden geçiyoruz. Biz de o şehre uğrayacağız, seni oraya " +
            "sağ salim ulaştırız merak etme. Sen dinlenmeye bak.\n\n" +
            "Mono uzun zaman sonra dinleniyordu ama içten içe kemiren kötü bir hissi vardı. " +
            "Yorgunluktan onu düşünemiyordu ve uyuya kaldı.\n\n" +
            "At arabası birden devrildi! Mono sersemlemişti. Çığlık sesleri havada yankılanıyordu. " +
            "Hemen yanındaki kılıcı alıp dışarı çıktı. Gördüğü manzara karşısında şok oldu...",
            BackgroundPanel.THEME_DARK, "▸", "", "", "");
    }

    void girisekrani4() {
        setScene("girisekrani4",
            "Küçük kız babasını canice öldürmüştü — suratına onlarca defa bıçak sallamıştı. " +
            "Ve annesine de aynısını yapmak için köşeye sıkıştırmıştı. Annesi çığlık atıp yardım istiyordu.\n\n" +
            "Mono olan bitenin farkına vardı — ruhlar bu aileyi de mahvediyordu. Buna dayanamıyordu. " +
            "Kılıcını çekip kızın arkasından kalbine doğru sapladı. İçinden kara ruh çıktı.\n\n" +
            "Etraftan gülme sesleri geliyordu. Ruhlar ona ve kadına gülüyorlardı.\n\n" +
            "Kadın, kızının gözünün önünde öldüğünü görünce delirmişçesine ağlamaya başladı. " +
            "Mono yanına doğru gitti — 'Zavallı kadın, zavallı adam, zavallı kız... Sadece bana yardım " +
            "etmek istiyorlardı. Neye yol açtım...'\n\n" +
            "Kadına yaklaştı. 'İyi misiniz?' Kadın kahkaha atmaya başladı. 'Kendin için endişelenmelisin!' " +
            "diyip üstüne saldırdı. Mono, onun da ruhlar tarafından ele geçirildiğini anladı. " +
            "Yapabileceği bir şey yoktu...\n\n" +
            "Güneş doğmaya başlamıştı. Ruhlar kayboluyordu. Mono kalktı, etrafına baktı. " +
            "Cesetleri bir araya toplayıp yaktı ve yoluna devam etti. Ufukta kale görünüyordu.",
            BackgroundPanel.THEME_DARK, "▸", "", "", "");
    }

    // --- TOWN GATE ---
    void towngate() {
        setScene("Town Gate",
            "Kale surlarının önündesin.\nŞövalye kapının önünde duruyor.\n\nNe yapacaksın?",
            BackgroundPanel.THEME_CASTLE, "Şövalye ile konuş", "Şövalyeye saldır", "Ayrıl", "");
    }

    void talkwizard() {
        setScene("Talkwizard",
            "Knight: Merhaba yabancı. Daha önce suratını görmemiştim. Bitap halde görünüyorsun, " +
            "başına neler geldi böyle?\n\n" +
            "Mono: Shiba köyünden buraya ailem tarafından gönderildim. Onlar için çok önemli birisiyle " +
            "konuşmam lazım. Günlerdir yoldayım.\n\n" +
            "Knight: Üzgünüm ama içeri girmene izin veremem.\n\n" +
            "Mono: Lütfen efendim, hayatım buna bağlı...",
            BackgroundPanel.THEME_CASTLE, "▸", "Geri dön", "", "");
    }

    void talkinstage2() {
        setScene("Talkwizard2",
            "Knight: Katiyen olmaz! Kralımıza suikast şüpheleri yüzünden seni asla içeri alamam. Uzak dur!\n\n" +
            "Mono: Lütfen efendim, günlerdir yoldayım. Tüm köyümün hayatı buna bağlı.\n\n" +
            "Knight: Dediğimi duymadın mı evlat? Sana zarar vermeden önce burayı terk et! " +
            "Rahatsız etme beni, meşgulüm.",
            BackgroundPanel.THEME_CASTLE, "Israr et", "Terk et", "", "");
    }

    void talkinstage3() {
        setScene("Talkwizard3",
            "Mono: Efendim, her şey buna bağlı. Ne isterseniz yaparım, lütfen!\n" +
            "Knight: ....\n" +
            "Mono: Yalvarırım efendim!\n\n" +
            "Knight: Aslında bir yolu var... Ama riskli. Ve aramızda kalmalı.\n\n" +
            "Mono: Tabii ki efendim, ne derseniz o.\n\n" +
            "Knight: Eğer bu dediklerimi başka birisine dersen — başka bir yerde dedikodusu duyarsam — " +
            "senin derini yüzerim.\n\n" +
            "Mono: Söz veriyorum efendim, kimseye bir şey demeyeceğim.",
            BackgroundPanel.THEME_CASTLE, "Kabul et", "Geri dön", "", "");
    }

    void talkinstage4() {
        setScene("Talkwizard4",
            "Knight: Karım ve çocuğum hasta. Kırmızı alarm verildiği için dışarı çıkamıyorum.\n\n" +
            "İçerideki pazarda binlerce dolara satılan şifalı bir bitki var — bu maaşla yüzlerce yıl " +
            "çalışsam alamam. Tek bir bölgede bulunuyor: LANETLİ ORMAN'ın batı kısmında.\n\n" +
            "Çıksam bile aşırı tehlikeli yaratıklarla dolu bir yer. Özellikle mavi gözlü o \n lanet cadı ona dikkat et" +
                    " seni cezbetmesine izin verme aşırı tehlikeli ve güçlü \n Ordan bana bir tane HERMES OTU " +
            "getirebilirsen — mavi ve gümüş rengi karışımında, kendini belli eden bir bitki — ormanda " +
            "diğer bitkilerden ayırt edebilirsin.\n\n" +
            "Bana getirirsen seni gizlice içeri sokabilirim. Gizli bir geçit biliyorum.",
            BackgroundPanel.THEME_CASTLE, "Kabul et", "Geri dön", "", "");
    }

    void talkinstage5() {
        setScene("Talkwizard5",
            "Knight: Kabul ettin demek... Bol şans, ihtiyacın olacak. Seni burada bekliyor olacağım.",
            BackgroundPanel.THEME_CASTLE, "Ayrıl", "", "", "");
    }

    // --- ATTACK ---
    void attackKnight() {
        player.hp -= 3;
        updateHUD();
        setScene("AttackKnight",
            "Knight: Hey! DON'T be stupid!\n\n" +
            "Şövalye karşılık verdi ve seni sert bir şekilde vurdu!\n\n" +
            "⚔ 3 hasar aldın!",
            BackgroundPanel.THEME_BATTLE, "Tekrar saldır", "Dinle", "Geri çekil", "Geri çekil");
    }

    // --- CROSSROAD ---
    void crossroad() {
        setScene("crossroad",
            "Yol ayrımındasın. Nereye gideceksin?\n\n" +
            "Güneye gidersen kaleye geri döneceksin.",
            BackgroundPanel.THEME_FOREST, "Kuzeye git", "Doğuya git", "Güneye git", "Batıya git");
    }

    void north() {
        player.hp += 2;
        updateHUD();
        setScene("north",
            "Bir nehir var. Su perisi seni gördü — yorgun ve üzgün haline acıdı.\n" +
            "Kutsal suyundan içmene izin verdi.\n\n" +
            "✦ 2 HP kazandın!",
            BackgroundPanel.THEME_FOREST, "", "Geri dön", "", "");
    }

    void east() {
        player.weapon = "LONG SWORD";
        updateHUD();
        setScene("east",
            "Ormanda yürürken yerde parlayan bir şey gördün...\n\n" +
            "Uzun bir kılıç buldun!\n\n" +
            "⚔ LONG SWORD elde ettin!",
            BackgroundPanel.THEME_FOREST, "Geri dön", "", "", "");
    }

    void west() {
        setScene("west",
            "Bir büyücüyle karşılaştın! Ne yapacaksın?\n\n" +
            "Büyücü HP: " + player.vikingHp,
            BackgroundPanel.THEME_BATTLE, "Dövüş!", "Kaç!", "", "");
    }

    void playerAttack() {
        int dmg = 0;
        if ("KNIFE".equals(player.weapon)) dmg = rand.nextInt(5);
        else if ("LONG SWORD".equals(player.weapon)) dmg = rand.nextInt(15);
        else if ("excalibur".equals(player.weapon)) dmg = rand.nextInt(45) + 30;
        else if ("Dagger of Death Flowers".equals(player.weapon)) dmg = rand.nextInt(100) + 70;

        player.vikingHp -= dmg;
        setScene("playerattack",
            "Büyücüye saldırdın!\n\n" +
            "⚔ " + dmg + " hasar verdin!\n" +
            "Büyücü HP: " + player.vikingHp,
            BackgroundPanel.THEME_BATTLE, "▸", "", "", "");
    }

    void monsterAttack() {
        int atk = rand.nextInt(5);
        player.hp -= atk;
        updateHUD();
        if (player.vikingHp < 0) { win(); return; }
        setScene("monsterattack",
            "Büyücü sana saldırdı!\n\n" +
            "💥 Sana " + atk + " hasar verdi!\n" +
            "Büyüsüyle seni yol dışına fırlattı.",
            BackgroundPanel.THEME_BATTLE, "▸", "", "", "");
    }

    void win() {
        player.hasSilverRing = true;
        setScene("win",
            "Büyücüyü yendin!\n\n" +
            "Büyücü bir yüzük düşürdü!\n\n" +
            "✦ Gümüş Yüzük elde ettin!\n\n" +
            "...bir ağlama sesi duydun.",
            BackgroundPanel.THEME_FOREST, "Geri dön", "İlgilen", "", "");
    }

    void lose() {
        setScene("lose",
            "Yenildin...\n\n" +
            "Karanlık seni yuttu.",
            BackgroundPanel.THEME_DARK, "", "", "", "");
        hpBar.setHp(0);
        if (hpBar != null) hpBar.repaint();
    }

    void ilgilen() {
        setScene("ilgilen",
            "Mono: KİM VAR ORDA?\n\n" +
            "Çocuk: Lütfen beni öldürme!\n\n" +
            "Mono: Sakin ol, sen de kimsin?\n\n" +
            "Çocuk: Ben az önce dövüştüğün büyücünün yardımcısıyım. Aslında iyi biri — ben evsiz " +
            "bir yetimken bana baktı, yardım etti, yetiştirdi...",
            BackgroundPanel.THEME_FOREST, "Geri dön", "", "", "");
    }

    // --- ENDING (ENTERING CASTLE) ---
    void ending() {
        setScene("ending",
            "Knight: Oh, döndün! O büyücüyü gerçekten öldürdün ha?\n" +
            "Göründüğünden çok daha güçlüymüşsün. Ama içeride dikkatli ol — dışarıdan daha tehlikeli.\n\n" +
            "Mono: İstediğin bitki.\n*Bitkiyi verir*\n\n" +
            "Knight: Sözüm söz, merak etme. Beni takip et.\n\n" +
            "**Karanlık geçitten geçilir**\n\n" +
            "Kalenin içindesin.",
            BackgroundPanel.THEME_CASTLE, "▸", "", "", "");
    }

    // --- INSIDE CASTLE ---
    void talkinstage6() {
        setScene("Talkwizard6",
            "***Işık süzmesi suratına vuruyor... Kalabalık sesleri duyuluyor***\n\n" +
            "Hayvanlar etrafta koşuşturuyor.\n\n" +
            "Şimdi ne yapacaksın?",
            BackgroundPanel.THEME_TOWN, "Tüccara git", "Bara git", "Kalabalığa git", "");
    }

    void tuccar() {
        setScene("tuccar",
            "Tüccar: Buyrun efendim, hoşgeldiniz! Ne istersiniz?\n\n" +
            "┌─────────────────────────────────────────┐\n" +
            "│  Şövalye Zırhı    │ 700$  │ +60 HP     │\n" +
            "│  Excalibur        │ 400$  │ 30-45 hasar│\n" +
            "│  Dagger of Death  │ 1000$ │ 70-100 hsr │\n" +
            "└─────────────────────────────────────────┘\n\n" +
            "Paran: " + player.money + "$",
            BackgroundPanel.THEME_TOWN, "Şövalye Zırhı", "Excalibur", "Dagger of Death", "Geri dön");
    }

    void sovalyeZirhi() {
        if (player.money >= 700) {
            player.hp += 60;
            player.money -= 700;
            updateHUD();
            mainText.setTypewriterText("Kesenize bereket efendim! Buyrun zırhınız.\n\n✦ +60 HP kazandın!");
        } else {
            papara2();
        }
    }

    void excalibur() {
        if (player.money >= 400) {
            player.weapon = "excalibur";
            player.money -= 400;
            updateHUD();
            mainText.setTypewriterText("Kesenize bereket efendim! Buyrun, efsanelerde adı geçen Excalibur kılıcınız.\n\n⚔ EXCALIBUR'A HÜKMETTİNİZ!");
        } else {
            papara2();
        }
    }

    void dimitrescu() {
        if (player.money >= 1000) {
            player.weapon = "Dagger of Death Flowers";
            player.money -= 1000;
            updateHUD();
            mainText.setTypewriterText("Kesenize bereket efendim! Buyrun, karanlıkların hükümdarı Lady Dimitrescu'nun Dagger of Death Flowers hançeri.\n\nDikkatli olunuz — aşırı derecede zehirlidir. Tek bir sıyrığı bile koca bir ejderi saniyeler içinde öldürebilir.\n\n⚔ Dagger of Death Flowers'a sahipsiniz!");
        } else {
            papara2();
        }
    }

    void bar() {
        setScene("bar",
            "*Bara giriş yaptın. Müzik çalıyor, kalabalık sesler her yerde.*\n\n" +
            "Barmen: Ne istersiniz? Buralarda yenisiniz galiba.\n\n" +
            "Mono: Herkes değil mi zaten.\n\n" +
            "Barmen: Evet haklısınız, burası büyük bir kale. Herkesi tanıyamazsınız.\n\n" +
            "Mono: 1 bira.\n\n" +
            "Barmen: Tabii efendim. *Birayı verir*",
            BackgroundPanel.THEME_BAR, "Büyücüyü sor", "Bir bira daha", "Black Jack", "Çıkış");
    }

    void beeer() {
        player.money -= 15;
        updateHUD();
        mainText.setTypewriterText("Buyrun efendim, içkiniz.\n\nParan: " + player.money + "$");
        if (player.money < 15) {
            papara();
        }
    }

    void papara() {
        setScene("papara",
            "YETERSİZ BAKİYE!",
            BackgroundPanel.THEME_BAR, "Tüccara git", "Sohbet", "Bardan çık", "Black Jack");
    }

    void papara2() {
        setScene("papara2",
            "YETERSİZ BAKİYE!",
            BackgroundPanel.THEME_TOWN, "Ayrıl", "", "", "");
    }

    void minigame() {
        if (player.money < 20) {
            papara();
            return;
        }
        player.money -= 20;
        updateHUD();
        setScene("minigame",
            "Giriş ücreti: 20$\n\n" +
            "🃏 Kart seçiniz!\n\n" +
            "Paran: " + player.money + "$",
            BackgroundPanel.THEME_BAR, "Karo", "Sinek", "Ayrıl", "");
    }

    void karo() {
        int sayi = rand.nextInt(10) + 1;
        if (sayi % 2 == 0) {
            player.money += 50;
            mainText.setTypewriterText("🎉 Tebrikler! 50$ kazandın!\n\nParan: " + player.money + "$");
        } else {
            player.money -= 30;
            mainText.setTypewriterText("💸 20$ kaybettin!\n\nParan: " + player.money + "$");
        }
        updateHUD();
    }

    void sinek() {
        int sayi = rand.nextInt(10) + 1;
        if (sayi % 2 == 0) {
            player.money += 50;
            mainText.setTypewriterText("🎉 Tebrikler! 50$ kazandın!\n\nParan: " + player.money + "$");
        } else {
            player.money -= 30;
            mainText.setTypewriterText("💸 20$ kaybettin!\n\nParan: " + player.money + "$");
        }
        updateHUD();
    }

    void rusvet() {
        setScene("rusvet",
            "Barmen: Bir şifacı mı? O şarlatanlardan her yerde var ama saklanıyorlar. " +
            "Eğer biri yakalanırsa engizisyon onları ip gibi sallandırır hahaha!\n\n" +
            "Mono: Sunsho diye birisini tanıyor musun?\n\n" +
            "Barmen: Hayır.\n\n" +
            "Mono: Peki nerde bulabileceğim hakkında bir bilgin var mı?\n\n" +
            "Barmen: Var ama bedavaya söylemem...",
            BackgroundPanel.THEME_BAR, "100$ rüşvet ver", "Ayrıl", "", "");
    }

    void talkingstage7() {
        if (player.money < 100) {
            mainText.setTypewriterText("Mono: Üzgünüm, o kadar param yok.\n\nBarmen: Uzak dur burdan! Seni şikayet etmediğim için şanslısın.");
            position = "kalabalik4";
            choices[0].setText("Ayrıl"); choices[1].setText(""); choices[2].setText(""); choices[3].setText("");
            choices[0].setVisible(true);
            for (int i=1;i<4;i++) choices[i].setVisible(false);
        } else {
            player.money -= 100;
            updateHUD();
            setScene("kalabalik4",
                "100 papel ha? Bak bu çalışır!\n\n" +
                "Büyücü arıyorsan bir duyum almıştım — buranın kuzeyinde, yüksek tepelerin ordaki " +
                "mezarlığın orada yaşayan bir büyücü duymuştum. Ordaki cesetlerle deney yapıldığı " +
                "dedikodusu yayılmış.\n\n" +
                "Ama dikkatli ol, seni bir kurbağaya çevirmesin hahaha!\n\n" +
                "Mono: Bilgi için teşekkürler.\n\n" +
                "Barmen: Dikkatli ol evlat, oralar biraz tehlikeli yerler. Başıboş hayvanlar ve evsizler var.",
                BackgroundPanel.THEME_BAR, "Oraya git", "", "", "");
        }
    }

    // --- CROWD ---
    void kalabalik() {
        setScene("kalabalik",
            "Kalabalığa doğru yöneldin. Bir idama şahit oldun. Kalabalık öfkeli — hep bir ağızdan " +
            "\"İDAM! İDAM!\" sesleri yükseliyordu.\n\n" +
            "İdam sehpasında uzun beyaz sakallı, sol gözü olmayan, sert bakışlı bir adam vardı. " +
            "Dik duruşundan hiç ödün vermiyordu.\n\n" +
            "Başında bekleyen adam konuşmaya başladı...",
            BackgroundPanel.THEME_TOWN, "▸", "", "", "");
    }

    void kalabalik2() {
        setScene("kalabalik2",
            "\"...ve ardından idam edilecek bir sürü hain! Krallığımıza zarar verip çökertmeye " +
            "çalışan, kendilerine 'Devrim Kulübü' diyen bir avuç soytarılar! Bugün hepsinin sonu gelecek. " +
            "Yılanın başının kesilmesinin zamanı geldi!\"\n\n" +
            "CELLAT: Var mıdır son sözün?",
            BackgroundPanel.THEME_TOWN, "▸", "", "", "");
    }

    void kalabalik3() {
        setScene("kalabalik3",
            "Devrim Lideri: Korkmayın halkım! Ben öldüm diye bu devrim bitecek değil — daha her şey " +
            "yeni başlıyor. Çok yakında devrim başlıyor!\n\n" +
            "Sizden istediğim tek şey: korkmayınız! Her şey sizin hakkınız. Sıkı durup birbirinize " +
            "kenetlenin!\n\n" +
            "*İdam sehpası devrilir...*",
            BackgroundPanel.THEME_TOWN, "Birisiyle konuş", "Ayrıl", "", "");
    }

    void kalabalik4() {
        setScene("kalabalik4",
            "Mono: Affedersiniz, bunlar da kim?\n\n" +
            "Yabancı: Buralarda yeni misin? Her neyse... Kralı devirmeye çalışan bir grup devrimci. " +
            "Kendilerine 'ASRIN MUHAFIZLARI' diyorlar.",
            BackgroundPanel.THEME_TOWN, "Ayrıl", "", "", "");
    }

    // --- HILL / CEMETERY ---
    void tepeye() {
        setScene("tepeye",
            "Mono bardan ayrılıp tepeye doğru yola koyulur. Issız sokakları geçer, birkaç kez köpek " +
            "saldırısından kurtulur.\n\n" +
            "En sonunda bahsedilen mezarlığın orasına gelir. Etrafta hiç insan yoktu. Akşam sökmek " +
            "üzereydi — yine ruhların gelmesinden endişeliydi.\n\n" +
            "Her tarafta yıkık evler vardı. Köşede bankta oturan yaşlı bir adam gördü. Yanına doğru gitti. " +
            "Yaşlı adam piposunu tüttürüyordu.\n\n" +
            "Mono: Merhaba efendim, ben Shiba köyünden geliyorum. Birisini arıyorum.\n" +
            "Adam: Kimi arıyordun evladım? Buralarda yeni misin? Buralara uğrayan pek olmaz. İsmin ne?\n" +
            "Mono: Mono Yamaguchi. Bir büyücü arıyorum — Kōgyoku isimli. Daha önce duydun mu?\n\n" +
            "*Adam şaşırır, piposunu ağzından düşürür*\n\n" +
            "Adam: Yamaguchi... Kolunda dövme var mı?",
            BackgroundPanel.THEME_CEMETERY, "▸", "", "", "");
    }

    void tepeye2() {
        setScene("tepeye2",
            "Çocuk kolundaki üçgen içindeki kitap ve kılıç dövmesini gösterir.\n\n" +
            "Adam: İnanamıyorum! Buralarda ne arıyorsun?\n\n" +
            "*Çocuğa sarılır*\n\n" +
            "Adam: Kim yaptı bu dövmeyi sana?\n" +
            "Mono: Babam, ben küçükken yapmış. Dövmem olduğunu nerden biliyorsun?\n\n" +
            "Adam: Hava kararmak üzere, gel... Bugün misafirimsin. Aradığın kişi benim.\n\n" +
            "Yıllar sonra torunuyla buluşmak ha... Ne büyük şans!\n\n" +
            "*İkisi birlikte eve girer*\n\n" +
            "— Devam edecek... —",
            BackgroundPanel.THEME_CEMETERY, "", "", "", "");
    }

    // ==================== DARK SCROLLBAR UI ====================
    static class DarkScrollBarUI extends javax.swing.plaf.basic.BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(80, 60, 40);
            this.trackColor = new Color(20, 15, 10);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton b = new JButton();
            b.setPreferredSize(new Dimension(0, 0));
            return b;
        }
    }
}
