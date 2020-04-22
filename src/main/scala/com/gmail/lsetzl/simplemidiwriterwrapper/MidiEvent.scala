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

  case class NoteOff(channel: Int, key: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = ShortMessage.NoteOff(channel, key)
  }

  case class NoteOn(channel: Int, key: Int, velocity: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = ShortMessage.NoteOn(channel, key, velocity)
  }

  case class PolyPressure(channel: Int, key: Int, pressure: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = ShortMessage.PolyPressure(channel, key, pressure)
  }

  case class ControlChange(channel: Int, number: Int, value: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = ShortMessage.ControlChange(channel, number, value)
  }

  case class ProgramChange(channel: Int, number: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = ShortMessage.ProgramChange(channel, number)
  }

  case class ChannelPressure(channel: Int, pressure: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = ShortMessage.ChannelPressure(channel, pressure)
  }

  case class PitchBend(channel: Int, value: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = ShortMessage.PitchBend(channel, value)
  }

  case class GMSystemOn(override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = SysexMessage.GMSystemOn
  }

  case class MasterVolume(value: Int, override val tick: Long) extends MidiEvent {
    override val midiMessage: MidiMessage = SysexMessage.GMSystemOn
  }

}