package com.gmail.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{MidiEvent => JMidiEvent}

trait MidiEvent {
  val midiMessage: MidiMessage
  val tick: Long

  def toJava: JMidiEvent = new JMidiEvent(midiMessage.toJava, tick)
}

object MidiEvent {

  case class Tempo(value: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = MetaMessage.Tempo(value)
  }

}