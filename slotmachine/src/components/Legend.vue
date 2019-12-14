<template>
  <div>
    <div class="Legend">
      <div class="Legend-item">
        <div class="Legend-itemTitle">€ 2.00</div>
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Lemon-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Lemon-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Lemon-512.png"
        >
      </div>
      <div class="Legend-item">
        <div class="Legend-itemTitle">€ 4.00</div>
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Watermelon-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Watermelon-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Watermelon-512.png"
        >
      </div>
      <div class="Legend-item">
        <div class="Legend-itemTitle">€ 8.00</div>
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Grapes-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Grapes-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Grapes-512.png"
        >
      </div>
      <div class="Legend-item">
        <div class="Legend-itemTitle">€ 16.00</div>
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Cherry-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Cherry-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/slot-machines/512/Cherry-512.png"
        >
      </div>
      <div class="Legend-item">
        <div class="Legend-itemTitle">€ 3.00</div>
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/casino-games/512/bar-512.png"
        >
      </div>
      <div class="Legend-item">
        <div class="Legend-itemTitle">€ 18.00</div>
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/casino-games/512/bar-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/casino-games/512/bar-512.png"
        >
      </div>
      <div class="Legend-item">
        <div class="Legend-itemTitle">€ 72.00</div>
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/casino-games/512/bar-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/casino-games/512/bar-512.png"
        >
        <img
          class="Legend-itemImage"
          src="https://cdn4.iconfinder.com/data/icons/casino-games/512/bar-512.png"
        >
      </div>
    </div>
    <div
      class="Legend-tip"
    >Add coins to add credit. Press space to Play. Click reel or press 1, 2 or 3 to lock. Brought to you by Lukas Koserwhich yarn</div>
  </div>
</template>

<script>
export default {
  name: "Legend"
};
</script>

<style scoped>
.Legend {
  display: flex;
  flex-direction: column;
  margin-top: 16px;
}
.Legend-item {
  width: 100%;
  display: flex;
}

.Legend-itemTitle {
  font-size: 10px;
  padding-top: 3px;
  width: 42px;
  color: rgb(150, 150, 150);
}

.Legend-itemImage {
  width: 20px;
}

.Legend-tip {
  margin-top: 8px;
  font-size: 10px;
  color: rgb(150, 150, 150);
}

.Legend-credit {
  margin-top: 8px;
  font-size: 10px;
  font-style: italic;
  color: rgb(150, 150, 150);
}
</style>