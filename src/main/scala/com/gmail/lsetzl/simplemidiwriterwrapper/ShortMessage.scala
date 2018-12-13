package com.gmail.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{MidiMessage => JMidiMessage, ShortMessage => JShortMessage}

trait ShortMessage extends MidiMessage {
  val command: ShortMessage.Command
  val channel: Int
  val data1: Int
  val data2: Int

  override def toJava: JMidiMessage = new JShortMessage(command.value, channel, data1, data2)
}

object ShortMessage {

  abstract class Command(val value: Int)

  object Command {

    case object NoteOff extends Command(0x80)

    case object NoteOn extends Command(0x90)

    case object PolyPressure extends Command(0xA0)

    case object ControlChange extends Command(0xB0)

    case object ProgramChange extends Command(0xC0)

    case object ChannelPressure extends Command(0xD0)

    case object PitchBend extends Command(0xE0)

  }

  case class NoteOff(override val channel: Int, key: Int) extends ShortMessage {
    override val command: Command = Command.NoteOff
    override val data1: Int = key
    override val data2: Int = 0
  }

  case class NoteOn(override val channel: Int, key: Int, velocity: Int) extends ShortMessage {
    override val command: Command = Command.NoteOn
    override val data1: Int = key
    override val data2: Int = velocity
  }

  case class PolyPressure(override val channel: Int, key: Int, pressure: Int) extends ShortMessage {
    override val command: Command = Command.PolyPressure
    override val data1: Int = key
    override val data2: Int = pressure
  }

  case class ControlChange(override val channel: Int, number: Int, value: Int) extends ShortMessage {
    override val command: Command = Command.ControlChange
    override val data1: Int = number
    override val data2: Int = value
  }

  case class ProgramChange(override val channel: Int, number: Int) extends ShortMessage {
    override val command: Command = Command.ProgramChange
    override val data1: Int = number
    override val data2: Int = 0
  }

  case class ChannelPressure(override val channel: Int, pressure: Int) extends ShortMessage {
    override val command: Command = Command.ChannelPressure
    override val data1: Int = pressure
    override val data2: Int = 0
  }

  case class PitchBend(override val channel: Int, value: Int) extends ShortMessage {
    protected val unsignedValue: Int = value + 8192
    override val command: Command = Command.PitchBend
    override val data1: Int = unsignedValue / 128
    override val data2: Int = unsignedValue % 128
  }

}