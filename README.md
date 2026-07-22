
<div align="center">
<!-- Banner Placeholder -->
<!-- <img src="https://via.placeholder.com/900x250/1a1a2e/00d4ff?text=🐍+Snake+MC+Challenge" alt="Snake MC Challenge Banner" width="100%"/> -->
<br/>

# 🐍 Snake MC Challenge

### *Die ultimative Minecraft Survival Challenge – hinterlasse deine Spur. Überquere sie nie.*

<br/>

[![Minecraft](https://img.shields.io/badge/Minecraft-26.1.2+-62B47A?style=for-the-badge&logo=minecraft&logoColor=white)](https://www.minecraft.net/)
[![Paper](https://img.shields.io/badge/Paper-API-F7C948?style=for-the-badge&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCI+PHBhdGggZmlsbD0id2hpdGUiIGQ9Ik0xNCAySDZhMiAyIDAgMCAwLTIgMnYxNmEyIDIgMCAwIDAgMiAyaDEyYTIgMiAwIDAgMCAyLTJWOGwtNi02eiIvPjwvc3ZnPg==&logoColor=black)](https://papermc.io/)
[![Java](https://img.shields.io/badge/Java-21+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Gradle](https://img.shields.io/badge/Gradle-Kotlin_DSL-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)
[![Stars](https://img.shields.io/github/stars/HenRun189/Snake-MC-Challenge?style=for-the-badge&color=yellow)](https://github.com/HenRun189/Snake-MC-Challenge/stargazers)
[![Issues](https://img.shields.io/github/issues/HenRun189/Snake-MC-Challenge?style=for-the-badge&color=red)](https://github.com/HenRun189/Snake-MC-Challenge/issues)

<br/>

[📥 Download](#-installation) · [🎮 Gameplay](#-gameplay) · [📖 Commands](#-commands) · [🛣️ Roadmap](#️-roadmap) · [🤝 Mitmachen](#-mitmachen)

</div>

---

## 📋 Überblick

**Snake MC Challenge** ist ein Paper-Plugin, das die legendäre *Snake Challenge* aus dem YouTube-Format direkt in Minecraft bringt. Jeder Spieler hinterlässt beim Bewegen eine permanente Spur aus einzigartigen Blöcken – zusammen formt die Gruppe eine riesige, weiterwachsende Schlange, die niemals sich selbst oder andere Spuren berühren darf.

Das Ziel? **Minecraft vollständig durchspielen** – von der ersten Holzaxt bis zum Tod des Enderdrachen – und dabei die Welt mit einem Labyrinth aus Spuren zu überziehen, das immer enger und gefährlicher wird.

> 💡 **Inspiriert von:** [BastiGHG – 5 LEUTE = XXL CHAOS CHALLENGE](https://youtu.be/QAQx3Uw-PeI?si=w6cC3cQ8omCMlph-)

---

## ✨ Features

- 🐍 **Automatische Spurenbildung** – Jeder Spieler hinterlässt beim Laufen permanent Blöcke
- 🎨 **Einzigartige Blöcke pro Spieler** – Jeder hat seinen eigenen, zufällig zugewiesenen Spurenblock
- 💀 **Sofortiger Spielende** – Tritt ein Spieler auf eine Spur, ist die Challenge verloren
- 🔄 **Neustart-Mechanismus** – Einfaches Zurücksetzen und Neubeginnen
- 👥 **Multiplayer-Support** – Für Teams jeder Größe konzipiert
- ⚙️ **Vollständig konfigurierbar** – Blöcke, Regeln und Verhalten per `config.yml` anpassen
- 📊 **Scoreboard-Integration** *(geplant)* – Übersicht der Spuren und Spielerzustände
- 🔊 **Sound-Feedback** *(geplant)* – Akustische Signale bei Regelbrüchen

---

## 🖼️ Showcase

> 📸 *Screenshots und GIFs werden nach dem ersten Release hier eingefügt.*

<div align="center">

| Gameplay GIF | Screenshot |
|---|---|
| ![Gameplay GIF Placeholder](https://via.placeholder.com/400x225/1a1a2e/00d4ff?text=GIF+coming+soon) | ![Screenshot Placeholder](https://via.placeholder.com/400x225/1a1a2e/62B47A?text=Screenshot+coming+soon) |

</div>

---

## 📥 Installation

> [!IMPORTANT]
> Das Plugin benötigt einen **Paper-Server 26.1.2 oder neuer**. Spigot oder Vanilla werden **nicht** unterstützt.

**Schritt 1: Plugin herunterladen**

Lade die neueste Version von der [Releases-Seite](https://github.com/HenRun189/Snake-MC-Challenge/releases) herunter.

**Schritt 2: In den Plugins-Ordner legen**

```
📁 server/
└── 📁 plugins/
└── 📄 SnakeMCChallenge-x.x.x.jar  ← hier ablegen
```

**Schritt 3: Server starten**

Starte deinen Paper-Server. Das Plugin erstellt automatisch eine `config.yml` im Ordner:

```
📁 plugins/
└── 📁 SnakeMCChallenge/
└── 📄 config.yml
```

**Schritt 4: Challenge starten**

Gib im Spiel `/snake start` ein und die Challenge beginnt!

---

## 💬 Commands

| Command | Beschreibung | Berechtigung |
|---|---|---|
| `/snake start` | Startet die Snake Challenge | `snake.admin` |
| `/snake stop` | Beendet die aktuelle Challenge | `snake.admin` |
| `/snake reset` | Setzt alle Spuren zurück | `snake.admin` |
| `/snake status` | Zeigt den aktuellen Challenge-Status | `snake.use` |
| `/snake setblock <Spieler> <Block>` | Setzt den Spurenblock eines Spielers manuell | `snake.admin` |
| `/snake reload` | Lädt die Konfiguration neu | `snake.admin` |
| `/snake help` | Zeigt alle verfügbaren Befehle | `snake.use` |

---

## 🔑 Permissions

| Permission | Beschreibung | Standard |
|---|---|---|
| `snake.admin` | Zugriff auf alle Admin-Befehle | `op` |
| `snake.use` | Grundlegende Spielerbefehle | `true` |
| `snake.bypass` | Ignoriert Spurenregeln (z. B. für Admins) | `op` |
| `snake.*` | Alle Berechtigungen | `op` |

---

## ⚙️ Konfiguration

<details>
<summary>📄 <strong>config.yml – Vollständige Übersicht anzeigen</strong></summary>

```yaml
# ╔════════════════════════════════════╗
# ║    Snake MC Challenge – Config     ║
# ╚════════════════════════════════════╝

snake:
  # Aktiviert/deaktiviert den Spur-Mechanismus global
  enabled: true

  # Spieler sterben sofort bei Berührung einer Spur (false = nur Meldung)
  instant-death: true

  # Blöcke, die als Spur hinterlassen werden können (zufällige Zuweisung)
  trail-blocks:
    - GOLD_BLOCK
    - DIAMOND_BLOCK
    - EMERALD_BLOCK
    - REDSTONE_BLOCK
    - LAPIS_BLOCK
    - IRON_BLOCK
    - QUARTZ_BLOCK
    - AMETHYST_BLOCK

  # Sonderregel: Beim Durchqueren von Portalen X Sekunden Immunität
  portal-immunity-seconds: 5

  # Ob eigene Spur ebenfalls zum Tod führt
  self-trail-kills: true

  # Nachrichten
  messages:
    challenge-start: "&a&l🐍 Die Snake Challenge hat begonnen! Hinterlasst eure Spur – und überquert sie nie."
    challenge-stop: "&c&lDie Challenge wurde beendet."
    player-died: "&c&l{player} hat eine Spur berührt! Game Over."
    trail-placed: "&7Deine Spur: &f{block}"
```

</details>

> [!TIP]
> Nach jeder Änderung an der `config.yml` kannst du mit `/snake reload` die Konfiguration neu laden, ohne den Server neu zu starten.

---

## 🎮 Gameplay

### Was ist die Snake Challenge?

Die Snake Challenge ist eine Survival-Challenge für Gruppen, inspiriert vom klassischen *Snake*-Spielprinzip – übertragen in die Minecraft-Welt.

### 🐍 Das Grundprinzip

Sobald die Challenge startet, hinterlässt **jeder Spieler bei jeder Bewegung dauerhaft Blöcke** auf dem Boden. Diese Blöcke verschwinden nicht – sie bleiben für immer. Jeder Spieler hat seinen eigenen, einzigartigen Block, sodass man stets erkennt, wessen Spur wo liegt.

Gemeinsam bildet die gesamte Gruppe eine einzige, riesige Schlange, die sich durch die Minecraft-Welt zieht.

### ⚠️ Die goldene Regel

> **Keine Spur darf jemals berührt oder gekreuzt werden – weder die eigene noch die eines anderen Spielers.**

Tritt auch nur ein einziger Spieler auf eine Spur, ist die Challenge **sofort und unwiderruflich verloren**. Dann heißt es: von vorne anfangen.

### 🌍 Die Welt wird enger

Was am Anfang harmlos aussieht, entwickelt sich mit der Zeit zu einem echten Albtraum. Die Welt füllt sich Schritt für Schritt mit Spuren:

- Beim **Holzfällen** entstehen Spuren um jeden Baum
- In **Dörfern** werden Wege schnell unpassierbar
- Im **Nether** sind enge Gänge und unerwartetes Knockback von Mobs lebensgefährlich
- Beim Bau von **Netherportalen** oder bei Kämpfen mit Mobs können fatale Fehler passieren

### 🤝 Teamwork ist alles

Die Challenge ist ohne Kommunikation und Planung schlicht nicht bestehbar:

- Spieler müssen sich **koordinieren**, wer welchen Weg nimmt
- **Rechte Winkel** und klare Laufwege helfen, Überschneidungen zu vermeiden
- Wenn jemand feststeckt, müssen **Brücken gebaut oder Umwege geplant** werden
- Beim **Schlafen** muss jeder aufpassen, nicht beim Aufwachen in eine Spur zu treten
- Im Nether gilt: **5 Sekunden Immunität** nach dem Portaldurchgang – diese Zeit muss strategisch genutzt werden, um sich sicher zu positionieren

### 🏆 Das Ziel

Das Ziel ist es, **Minecraft vollständig durchzuspielen** – trotz aller Einschränkungen. Das bedeutet: Ressourcen sammeln, den Nether betreten, Blazerods und Enderperlen farmen und schließlich die **Enderburg finden und den Enderdrachen besiegen**.

Ein einziger Fehler reicht aus – und alles beginnt von vorne. 🐉

---

## 🛣️ Roadmap

- [x] 🐍 Grundlegende Spurenmechanik
- [x] 🎨 Einzigartige Blöcke pro Spieler
- [x] 💀 Challenge-Ende bei Spurenberührung
- [x] ⚙️ Konfigurationsdatei (`config.yml`)
- [ ] 🖥️ GUI für Spielereinstellungen
- [ ] 📊 Scoreboard-Integration
- [ ] 🔊 Sound-Effekte bei Ereignissen
- [ ] 📢 BossBar mit Challenge-Status
- [ ] 🏷️ PlaceholderAPI-Unterstützung
- [ ] 📈 Spielerstatistiken (Schrittzähler, Challenge-Versuche)
- [ ] 🔌 Öffentliche API für andere Plugins
- [ ] 🌐 Mehrsprachigkeit (i18n)
- [ ] ⚡ Performance-Optimierungen für große Server

> 💬 Hast du Feature-Ideen? [Erstelle ein GitHub Issue!](https://github.com/HenRun189/Snake-MC-Challenge/issues/new)

---

## 🤝 Mitmachen

Contributions sind herzlich willkommen! 🎉

**So kannst du mitmachen:**

1. **Fork** das Repository
2. Erstelle einen **Feature-Branch**: `git checkout -b feature/MeinFeature`
3. **Committe** deine Änderungen: `git commit -m 'feat: MeinFeature hinzugefügt'`
4. **Pushe** den Branch: `git push origin feature/MeinFeature`
5. Öffne einen **Pull Request**

> [!NOTE]
> Bitte halte dich an den bestehenden Code-Stil und füge für neue Features entsprechende Tests hinzu.

<details>
<summary>📌 <strong>Contribution-Regeln</strong></summary>

- Verwende **Java 21+** und den bestehenden Gradle-Build
- Befolge die [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Schreibe **aussagekräftige Commit-Messages** (z. B. `feat:`, `fix:`, `docs:`)
- Teste dein Plugin auf einem **lokalen Paper 26.1.2+ Server** bevor du einen PR öffnest
- Beschreibe in deinem PR **was** du geändert hast und **warum**

</details>

---

## 🔨 Building

Stelle sicher, dass **Java 21+** installiert ist. Dann führe folgenden Befehl im Projektverzeichnis aus:

```bash
# Plugin bauen (JAR wird in build/libs/ erstellt)
./gradlew build

# Alternativ unter Windows:
gradlew.bat build
```

Die fertige `.jar`-Datei befindet sich anschließend unter:

```
build/libs/SnakeMCChallenge-x.x.x.jar
```

---

## 🆘 Support

Hast du einen Bug gefunden oder brauchst Hilfe?

- 🐛 **Bug melden:** [GitHub Issues](https://github.com/HenRun189/Snake-MC-Challenge/issues/new?labels=bug)
- 💡 **Feature vorschlagen:** [GitHub Issues](https://github.com/HenRun189/Snake-MC-Challenge/issues/new?labels=enhancement)
- ❓ **Fragen stellen:** [GitHub Discussions](https://github.com/HenRun189/Snake-MC-Challenge/discussions)

> [!WARNING]
> Bitte öffne **keine** Issues für allgemeine Minecraft-Probleme oder Plugin-Konflikte, die nichts mit Snake MC Challenge zu tun haben.

---

## 📜 Lizenz

Dieses Projekt steht unter der **MIT License**.

```
MIT License

Copyright (c) 2026 Henri Himmelmann and Julian Mi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

[Vollständige Lizenz lesen →](LICENSE)

---

## 👨‍💻 Credits

<div align="center">

Entwickelt mit ❤️ von

**Julian Mi (JuMiKon)**

**Henri Himmelmann**





[![GitHub](https://img.shields.io/badge/GitHub-HenRun189-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/HenRun189)

*Inspiriert durch das YouTube-Video von [BastiGHG](https://www.youtube.com/@BastiGHG)*

<br/>

⭐ Wenn dir dieses Plugin gefällt, hinterlasse einen **Star** auf GitHub! ⭐

</div>

---

<div align="center">
<sub>Snake MC Challenge • Paper 1.21.6+ • MIT License • Made in Germany 🇩🇪</sub>
</div>
