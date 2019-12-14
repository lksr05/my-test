<template>
  <div class="SlotMachine">
    <div class="SlotMachine-stats">
      <div class="SlotMachine-coin" v-on:mousedown="insertCoin()"></div>
      <div class="SlotMachine-stat is-credit">
        <div class="SlotMachine-statTitle">Credits</div>
        <div class="SlotMachine-statValue">€ {{credits.toFixed(2)}}</div>
        <div class="SlotMachine-statSub">spend € {{spend.toFixed(2)}}</div>
      </div>
      <div class="SlotMachine-stat is-win">
        <div class="SlotMachine-statTitle">Won</div>
        <div class="SlotMachine-statValue">€ {{win.toFixed(2)}}</div>
      </div>
    </div>
    <div class="SlotMachine-reels">
      <div class="SlotMachine-shadow"></div>
      <div class="SlotMachine-payline"></div>
      <SlotReel ref="reel1" :canlock="canlock" v-on:stopped="reelStopped"></SlotReel>
      <SlotReel ref="reel2" :canlock="canlock" v-on:stopped="reelStopped"></SlotReel>
      <SlotReel ref="reel3" :canlock="canlock" v-on:stopped="reelStopped"></SlotReel>
    </div>
    <div class="SlotMachine-actions">
      <button class="SlotMachine-button is-spin" v-on:mousedown="spin()">Play</button>
      <div
        class="SlotMachine-button is-win"
        v-bind:class="{'has-win':win}"
        v-on:mousedown="takeWin()"
      >Take Win</div>
    </div>
    <Legend></Legend>
  </div>
</template>

<script>
import SlotReel from "./SlotReel";
import Legend from "./Legend";

export default {
  name: "SlotMachine",
  components: {
    SlotReel,
    Legend
  },
  data() {
    return {
      spend: 6,
      credits: 6,
      win: 0,
      resultData: false,
      canlock: true,
      waslocked: false,
      audio: {
        barWin: new Audio(
          "https://freesound.org/data/previews/337/337049_3232293-lq.mp3"
        ),
        win: new Audio(
          "https://freesound.org/data/previews/387/387232_1474204-lq.mp3"
        ),
        insertCoin: new Audio(
          "https://freesound.org/data/previews/276/276091_5123851-lq.mp3"
        ),
        bigwin: new Audio(
          "https://freesound.org/data/previews/270/270319_5123851-lq.mp3"
        )
      }
    };
  },
  mounted() {
    window.addEventListener("keydown", this.keydown);
  },
  methods: {
    keydown(e) {
      const key = {
        one: 49,
        two: 50,
        three: 51,
        space: 32
      };
      if (e.which === key.one) {
        this.$refs.reel1.lock();
        e.preventDefault();
      } else if (e.which === key.two) {
        this.$refs.reel2.lock();
        e.preventDefault();
      } else if (e.which === key.three) {
        this.$refs.reel3.lock();
        e.preventDefault();
      } else if (e.which === key.space) {
        this.spin();
        e.preventDefault();
      }
    },
    spin() {
      if (this.credits > 0 && !this.resultData) {
        this.resultData = [];
        this.credits = this.credits - 0.5;
        this.$refs.reel1.run();
        this.$refs.reel2.run();
        this.$refs.reel3.run();
      }
    },
    insertCoin() {
      this.audio.insertCoin.currentTime = 0;
      this.audio.insertCoin.play();
      this.credits += 0.5;
      this.spend += 0.5;
    },
    takeWin() {
      if (this.win > 0) {
        this.credits += this.win;
        this.win = 0;
      }
    },
    reelStopped(resultData, wasLocked) {
      if (wasLocked) this.waslocked = wasLocked;
      this.resultData.push(resultData);
      if (this.resultData.length === 3) {
        this.checkWin(this.resultData);
        if (this.waslocked) {
          this.waslocked = false;
          this.canlock = false;
        } else {
          this.canlock = true;
        }
      }
    },
    checkWin() {
      if (this.resultData.length === 3) {
        // ;-)
        const v1 = this.resultData[0];
        const v2 = this.resultData[1];
        const v3 = this.resultData[2];
        if (v1.name === v2.name && v2.name === v3.name) {
          if (v1.value >= 8) {
            this.audio.bigwin.play();
          } else {
            this.audio.win.play();
          }
          this.win += v1.value;
          this.waslocked = true; // prevent lock after an unlocked win
        } else {
          const bar1 = v1.name === "Bar";
          const bar2 = v2.name === "Bar";
          const bar3 = v3.name === "Bar";
          if ((bar1 && bar2) || (bar1 && bar3) || (bar2 && bar3)) {
            this.audio.bigwin.play();
            this.win += 18;
            this.waslocked = true; // prevent lock after an unlocked win
          } else if (bar1 || bar2 || bar3) {
            // this.audio.win.play()
            // this.audio.barWin.play()
            this.win += 3;
            this.waslocked = true; // prevent lock after an unlocked win
          } else {
            // Lose : (
          }
        }
      }
      this.resultData = false;
    }
  }
};
</script>

<style scoped>
.SlotMachine {
  border-radius: 5px;
  width: 270px;
}
.SlotMachine-reels {
  display: flex;
  position: relative;
}
.SlotMachine-shadow {
  pointer-events: none;
  z-index: 99;
  position: absolute;
  width: 100%;
  height: 100%;
  box-shadow: inset 0 25px 30px -5px rgba(0, 0, 0, 0.1),
    inset 0 5px 10px -2px rgba(0, 0, 0, 0.2),
    inset 0 -25px 30px -5px rgba(0, 0, 0, 0.1),
    inset 0 -5px 10px -2px rgba(0, 0, 0, 0.2);
}
.SlotMachine-payline {
  position: absolute;
  top: 104.994px;
  height: 1px;
  width: 100%;
  background: rgba(0, 0, 0, 0.3);
}

.SlotMachine-stats {
  box-shadow: inset 0 25px 30px -5px rgba(0, 0, 0, 0.1),
    inset 0 5px 10px -2px rgba(0, 0, 0, 0.2),
    inset 0 -25px 30px -5px rgba(0, 0, 0, 0.1),
    inset 0 -5px 10px -2px rgba(0, 0, 0, 0.2);
  border-radius: 4px 4px 0 0;
  display: flex;
  background: #000;
  justify-content: flex-end;
  padding: 10px 0;
}
.SlotMachine-coin {
  width: 6px;
  height: 38px;
  background: gray;
  border: 3px solid rgb(40, 40, 40);
  border-radius: 6px;
  margin: 12px 10px 0 10px;
}
.SlotMachine-coin:hover {
  background: rgb(140, 140, 140);
}
.SlotMachine-stat {
  display: flex;
  flex-direction: column;
  margin-right: 10px;
  flex-grow: 1;
}
.SlotMachine-statTitle {
  font-size: 12px;
  color: rgb(90, 90, 90);
}
.SlotMachine-statValue {
  padding: 5px 10px;
  background: rgba(255, 0, 0, 0.15);
  border-radius: 2px;
  border: 1px solid rgb(0, 0, 0);
  font-size: 25px;
  text-align: right;
  color: rgba(255, 0, 0, 0.8);
  text-shadow: 0 0 4px rgba(255, 0, 0, 0.5);
  white-space: nowrap;
}
.SlotMachine-statSub {
  font-size: 9px;
  color: rgb(80, 80, 80);
  text-align: right;
}

.SlotMachine-actions {
  padding: 20px 10px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: end;
  -ms-flex-pack: end;
  justify-content: flex-end;
  background: rgb(20, 20, 20);
  border-radius: 0 0 4px 4px;
}
.SlotMachine-button {
  font-size: 17px;
  font-weight: bold;
  padding: 14px 12px;
  margin-left: 20px;
  border-radius: 5px;
  -webkit-box-shadow: 0 1px 2px 2px rgb(0, 0, 0);
  box-shadow: 0 1px 2px 2px rgb(0, 0, 0);
}
.SlotMachine-button:focus {
  outline: none;
}
.SlotMachine-button:active {
  -webkit-box-shadow: 0 0 2px 1px rgb(0, 0, 0);
  box-shadow: 0 0 2px 1px rgb(0, 0, 0);
}

.SlotMachine-button.is-spin {
  background: rgba(0, 255, 0, 0.4);
  border: 1px solid rgba(0, 255, 0, 0.4);
}
.SlotMachine-button.is-spin:hover {
  background: rgba(0, 255, 0, 0.43);
}
.SlotMachine-button.is-spin:active {
  background: rgba(0, 255, 0, 0.46);
}

.SlotMachine-button.is-win {
  background: rgba(255, 0, 0, 0.4);
  border: 1px solid rgba(255, 0, 0, 0.5);
}
.SlotMachine-button.is-win.has-win {
  background: rgba(255, 0, 0, 0.99);
}
.SlotMachine-button.is-win:hover {
  background: rgba(255, 0, 0, 0.65);
}
.SlotMachine-button.is-win:active {
  background: rgba(255, 0, 0, 0.7);
}
</style>
