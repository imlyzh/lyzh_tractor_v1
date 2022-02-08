import Chisel._
import chisel3.util.MixedVec


class Ex1 extends Module {
  val io = IO(new Bundle {
    val inst = Input(new DecodeOutput)
    val regfileio = Input(new RegFileIO)
    val waddr = Output(UInt(5.W))
    val rd = Output(UInt(64.W))
  })

  val alu = Module(new ALU)
  alu.io.alu_op := io.inst.op_type
  alu.io.in1 := in1
  alu.io.in2 := in2


  val in1 = Wire(UInt(64.W))

  val in2 = MuxLookup(io.inst.inst_type, 0.U, Array(
    InstType.I -> MixedVec(io.inst.funct7_imm, io.inst.rs2),
  ))

  io.regfileio.ren := true.B
  io.regfileio.rs1addr := io.inst.rs1
  in1 := io.regfileio.rs1

  val result = MuxLookup(io.inst.exec_type, 0.U, Array(
    ExecType.alu -> alu.io.out,
  ))

  io.waddr := io.inst.rd_imm04_imm1411
  io.rd := result
}


class ALU extends Module {
  val io = IO(new Bundle {
    val in1 = Input(UInt(64.W))
    val in2 = Input(UInt(64.W))
    val alu_op = Input(ALUType.instence())
    val out = Output(UInt(64.W))
  })

  io.out := MuxLookup(io.alu_op, 0.U, Array(
    ALUType.add -> (io.in1 + io.in2),
    ALUType.sub -> (io.in1 - io.in2),
    // todo
    ALUType.xor -> (io.in1 ^ io.in2),
    ALUType.or  -> (io.in1 | io.in2),
  ))
}