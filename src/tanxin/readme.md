
**贪心算法**
392 455 435 376
什么情况下动态规划问题能用贪心算法解决？需要满足贪心选择性质。
贪心选择性质，在求解一个最优化的问题中，我们使用贪心的方式选择了一组内容之后，不会影响剩下的子问题的求解。


所谓贪心算法是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，它所做出的仅仅是在某种意义上的局部最优解。
贪心算法没有固定的算法框架，算法设计的关键是贪心策略的选择。必须注意的是，贪心算法不是对所有问题都能得到整体最优解，选择的贪心策略必须具备无后效性（即某个状态以后的过程不会影响以前的状态，只与当前状态有关。）

贪心算法套路：
从问题的某一初始解出发：
while (朝给定总目标前进一步)
{
利用可行的决策，求出可行解的一个解元素。
}
由所有解元素组合成问题的一个可行解；