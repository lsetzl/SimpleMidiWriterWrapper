package com.gmail.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{MidiMessage => JMidiMessage}

trait MidiMessage {
  def toJava: JMidiMessage
}
