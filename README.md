# Spider-Man Mod (Fabric 1.21.1)

Mobil launcher'larda (Zalith, PojavLauncher, FCL) çalışması için **Minecraft 1.21.1 + Fabric** için yazıldı.

## Modda neler var?

| Eşya | Ne yapar? |
|---|---|
| Ağ Atıcı (Web Shooter) | Elinde tutup **sağ tık'a basılı tut**: baktığın bloğa ağ atar, seni çeker, sallanırsın |
| Örümcek Kostümü (maske, üst, pantolon, bot) | Normal zırh, özel özellik yok (şimdilik) |
| OP Kılıç / OP Kazma / OP Balta | Çok güçlü, 4000 dayanıklılık |

Kostümü giymeden de ağ atıcıyı kullanabilirsin.

### Ağ atıcı kontrolleri
- **Sağ tık (basılı tut):** ağ at ve sallan
- **Zıpla tuşu:** ipi kısalt (yukarı çek)
- **İleri tuşu:** bakış yönüne ekstra hız
- **Sağ tıkı bırak:** ağ kopar, hızınla uçarsın
- Ağ atıcı kullanırken ve sonraki 4 saniye **düşme hasarı almazsın**

### Creative modu
Creative envanterinde **"Spider-Man Modu"** sekmesinde tüm eşyalar var.

### Tarifler (survival)
- **Ağ Atıcı:** `S I S / I R I / S I S` → S = ip (string), I = demir külçe, R = redstone
- **Maske:** 5 kırmızı yün (`RRR / R R`)
- **Üst:** `R R / RRR / BBB` → kırmızı + mavi yün
- **Pantolon:** 7 mavi yün (`BBB / B B / B B`)
- **Bot:** 4 kırmızı yün (`R R / R R`)
- **OP Kılıç / Kazma / Balta:** netherite bloğu + çubuk (normal kılıç/kazma/balta şekli, kılıç için 2 blok)

## .jar dosyasını nasıl alırım? (GitHub ile, bilgisayar gerekmez)

1. https://github.com adresinde ücretsiz hesap aç.
2. Yeni bir repo oluştur (ör. `spidermod`).
3. Bu klasördeki **tüm dosyaları** repoya yükle (`Add file` → `Upload files`).
   `.github` klasörü de yüklenmeli (içinde `workflows/build.yml` var).
   Yükleyemezsen zip'i aç, klasörleri aynen koru.
4. Repoda **Actions** sekmesine gir → **Build Mod** çalışır (2-5 dakika).
5. Yeşil tik çıkınca işe tıkla, aşağıda **Artifacts → spidermod-jar** dosyasını indir (zip).
6. Zip'in içindeki **`spidermod-1.0.0.jar`** dosyası modun kendisi. (`-sources.jar` dosyasını kullanma.)

Kırmızı X çıkarsa hata mesajını bana yapıştır, düzeltirim.

## Launcher'a kurulum
1. Launcher'da **Fabric 1.21.1** profili kur (Fabric Loader 0.16.x).
2. **Fabric API** modunu indir (1.21.1 sürümü): https://modrinth.com/mod/fabric-api
3. `spidermod-1.0.0.jar` + `fabric-api-...jar` dosyalarını oyunun `mods` klasörüne koy.
4. Oyunu aç, Creative'de **Spider-Man Modu** sekmesine bak.

> Not: Kod şu an kendi ortamımda derlenemedi (internet erişimi kapalıydı), bu yüzden ilk derlemede küçük bir hata çıkabilir.
