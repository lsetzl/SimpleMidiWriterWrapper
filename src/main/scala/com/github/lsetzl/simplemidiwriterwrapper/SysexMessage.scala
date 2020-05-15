package com.github.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{MidiMessage => JMidiMessage, SysexMessage => JSysexMessage}

trait SysexMessage extends MidiMessage {
  val data: Seq[Int]

  override def toJava: JMidiMessage = {
    new JSysexMessage((List(0xf0) ++ data :+ 0xf7).map(_.toByte).toArray, data.length)
  }
}

object SysexMessage {

  case object GMSystemOn extends SysexMessage {
    override val data: Seq[Int] = List(0x7e, 0x7f, 0x09, 1)
  }

  case class MasterVolume(value: Int) extends SysexMessage {
    override val data: Seq[Int] = List(0x07, 0x7f, 0x7f, 0x04, 0x01, 0x00, value)
  }

}
