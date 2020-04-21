/* eslint-disable no-unused-vars */

var num1
var num2
var op
var result
var input
var buttonValue
var history = ['', '']
var calculation

function getNums () {
  input = document.getElementById('inputField').innerHTML
  var index = input.indexOf('+')
  if (index !== -1) {
    op = '+'
  }
  if (index === -1) {
    index = input.indexOf('-')
    op = '-'
  }
  if (index === -1) {
    index = input.indexOf('*')
    op = '*'
  }
  if (index === -1) {
    index = input.indexOf('/')
    op = '/'
  }
  num1 = input.slice(0, index)

  num2 = input.slice(index + 1)
}

function calc () {
  getNums()

  if (op === '+') {
    result = parseFloat(num1) + parseFloat(num2)
  }
  if (op === '-') {
    result = num1 - num2
  }
  if (op === '*') {
    result = num1 * num2
  }
  if (op === '/') {
    result = num1 / num2
  }

  document.getElementById('inputField').innerHTML = result
}

function getCalculation () {
  calculation = '' + num1 + op + num2
}

function add (buttonValue) {
  document.getElementById('inputField').innerHTML += buttonValue
}

function xclear () {
  addHistory()
  document.getElementById('inputField').innerHTML = ''
}

function addHistory () {
  getCalculation()
  history.push(calculation)
}

function callHistory () {
  console.log(history[1])
}
