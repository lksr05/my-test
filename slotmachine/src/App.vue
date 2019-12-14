<template>
  <div id="app">
    <SlotMachine></SlotMachine>
  </div>
</template>

<script>
import SlotMachine from "@/components/SlotMachine";

export default {
  name: "App",
  components: {
    SlotMachine
  }
};
</script>

<style>
:root {
  --tileSize: 90px;
}
html,
body {
  margin: 0;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  cursor: default;
}
#app {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
