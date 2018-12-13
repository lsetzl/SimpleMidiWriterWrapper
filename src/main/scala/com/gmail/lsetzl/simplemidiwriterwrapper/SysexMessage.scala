package com.gmail.lsetzl.simplemidiwriterwrapper

import javax.sound.midi.{MidiMessage => JMidiMessage, SysexMessage => JSysexMessage}

case class SysexMessage(data: Seq[Byte]) extends MidiMessage {
  override def toJava: JMidiMessage = new JSysexMessage(data.toArray, data.length)
}

object SysexMessage {
  def build(data: Seq[Int]): SysexMessage = SysexMessage((List(0xf0) ++ data :+ 0xf7).map(_.toByte))
}