# ADVENTURE GAME - Mono'nun Oykusu

Metin tabanli bir macera oyunu. Java Swing ile yazildi.

Shiba koyunde bir lanet yayilmistir. Ekinler soluyor, cocuklar daha dogmadan oluyor, her aksam evlerin onunden karanlik siluetler geciyor. Kucuk yasta babasini kaybeden Mono, kardesinin iblisler yuzunden komaya girmesiyle bu laneti kirmak icin tek basina Cantra sehrindeki kaleye yola cikar.

Yolculugu tehlikelerle doludur. Ruhlar pesini birakmaz, karanlik her kosede pusuya yatmistir. Ama Mono'nun tasidigi kilic ve kolundaki gizemli dovme, siradan bir koylü cocugu olmadiginin isaretleridir.

Lanetli ormanlardan gececek, dusmanlarla savasacak, ittifaklar kuracak ve ailesinin karanlik sirlarini kesfedeceksin.


## Ozellikler

- Hikaye odakli oynanis: Secimleriniz hikayeyi farkli yonlere goturur
- Savas sistemi: Farkli silahlara gore degisen hasar degerleri
- Ekonomi sistemi: Para kazanma, harcama, kumar ve rusvet mekanikleri
- Dukkan: Zirhlar ve silahlar satin alinabilir
- Karakter gelisimi: HP, silah ve para yonetimi
- Atmosferik arayuz: Gradient arka planlar, hover efektli butonlar, HP bari, typewriter efekti

## Gereksinimler

- Java 8 veya ustu
- JDK (Java Development Kit)


## Kurulum ve Calistirma

1. Tum .java dosyalarini ayni klasore koyun
2. images/ klasorunu ayni yere olusturun (gorsel eklemek isterseniz)
3. Terminal veya komut satirindan:

```
javac *.java
java Game
```


## Dosya Yapisi

```
adventure-game/
  Game.java              
  PlayerState.java       
  BackgroundPanel.java   
  StyledButton.java      
  HPBar.java           
  TypewriterTextArea.java  
  images/               
    castle.png          
    forest.gif          
    ...
```



Sahne adlari:
- intro: Giris sahnesi
- road: Yol sahnesi
- castle: Kale sahnesi
- forest: Orman sahnesi
- battle: Savas sahnesi
- crossroad: Yol ayirimi
- river: Nehir sahnesi
- bar: Bar sahnesi
- shop: Dukkan sahnesi
- town: Kasaba sahnesi
- cemetery: Mezarlik sahnesi
- win: Zafer sahnesi
- lose: Olum sahnesi

## Silahlar

| Silah | Hasar | Nerden |
|-------|-------|--------|
| Knife | 0-5 | Baslangic silahi |
| Long Sword | 0-15 | Ormanda bulunur |
| Excalibur | 30-45 | Tuccardan 400$ |
| Dagger of Death Flowers | 70-100 | Tuccardan 1000$ |


## Ekran Goruntuleri

<p align="center">
  <img src="Ekran görüntüsü 2026-04-19 163707.png" width="700"/>
</p>

<p align="center">
  <img src="Ekran görüntüsü 2026-04-19 163736.png" width="700"/>
</p>

<p align="center">
  <img src="Ekran görüntüsü 2026-04-19 163826.png" width="700"/>
</p>

<p align="center">
  <img src="Ekran görüntüsü 2026-04-19 163842.png" width="700"/>
</p>

<p align="center">
  <img src="Ekran görüntüsü 2026-04-19 163854.png" width="700"/>
</p>

<p align="center">
  <img src="Ekran görüntüsü 2026-04-19 163912.png" width="700"/>
</p>

<p align="center">
  <img src="Ekran görüntüsü 2026-04-19 163922.png" width="700"/>
</p>

## Lisans

Bu proje kişisel bir projedir ve ticari kullanım için açık değildir. Tüm hakları Mazlum Atila'ya aittir.
